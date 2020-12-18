package com.wuqy.service.log;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongManageLog;
import com.wuqy.common.entity.content.JinhongManageLogExample;
import com.wuqy.common.entity.content.JinhongWords;
import com.wuqy.common.util.GenerateLogUtil;
import com.wuqy.common.vo.Page;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.persist.mapper.BaseMapper;
import com.wuqy.persist.mapper.content.JinhongAccountMapper;
import com.wuqy.persist.mapper.content.JinhongManageLogMapper;
import com.wuqy.persist.mapper.content.JinhongWordsMapper;
import com.wuqy.service.common.AbstractService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Service
public class ManagerLogService extends AbstractService<JinhongManageLog, JinhongManageLogExample, Integer> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JinhongManageLogMapper manageLogMapper;

    @Autowired
    private JinhongAccountMapper accountMapper;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private JinhongWordsMapper wordsMapper;

    @Override
    protected BaseMapper<JinhongManageLog, JinhongManageLogExample, Integer> getRepository() {
        return manageLogMapper;
    }

    @Override
    public Page<JinhongManageLog> page(JinhongManageLogExample example, int page, int pageSize) {
        example.setOrderByClause(" create_time desc");
        com.github.pagehelper.Page<JinhongManageLog> pageResult = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                manageLogMapper.selectByExample(example);
            }
        });

        List<JinhongManageLog> list = pageResult.getResult();
        for(int seq = 0; seq < list.size(); seq++) {
            list.get(seq).setId(seq+1);
        }
        return new Page<>(pageResult.getResult(), pageResult.getTotal());
    }

    private ExecutorService executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors()*2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100),
            new ThreadFactoryBuilder().setNameFormat("executorService-%d").build());

    public void saveLog(JinhongManageLog entity) {
        logger.info(JSONObject.toJSONString(entity));
        executorService.execute(() -> {
            try {
                manageLogMapper.insert(entity);
            } catch (Exception e) {
                logger.warn("ManagerLogService saveLog error:{}", entity, e);
            }
        });
    }

//    @Scheduled(initialDelay = 20000, fixedDelay = 3600000)
    public void initManagerLog() {
        JinhongManageLog jinhongManageLog = manageLogMapper.selectMinMaxTime();
        if(null == jinhongManageLog) {
            addDayDate(new DateTime().minusDays(90).toDate(), new DateTime().minusDays(1).toDate(), true);
        } else if(null != jinhongManageLog.getMaxTime()) {
            logger.info("initManagerLog add data:"+new DateTime(jinhongManageLog.getMaxTime()).toString("yyyy-MM-dd HH:mm:ss"));
            if(new DateTime(jinhongManageLog.getMaxTime()).plusDays(1).getMillis() < System.currentTimeMillis()) {
                addDayDate(jinhongManageLog.getMaxTime(), new Date(), false);
            }
        }
    }

    public void addDayDate(Date beginDate, Date endDate, boolean isAddWords) {
        List<String> words = getWordsConfig();
        int wordLeng = 0;
        //每隔1-3天增加访问日志
        while(beginDate.getTime() < endDate.getTime()) {
            try {
                List<JinhongManageLog> visitLog = Lists.newArrayList();
                List<JinhongWords> jinhongWords = Lists.newArrayList();
                int dayLogNum = GenerateLogUtil.dayLogNum();
                int dayAdd = GenerateLogUtil.dayAdd();
                JinhongAccount jinhongAccounts = accountMapper.selectRandom1();
                Date insertDay = GenerateLogUtil.randomTimeByDate(beginDate);
                visitLog.add(JinhongManageLog.builder().nick(jinhongAccounts.getNick())
                        .account(jinhongAccounts.getAccount())
                        .result(RspConstants.SUCCESS).msg(RspConstants.LOGIN_SUCCESS)
                        .module(RspConstants.LOGIN)
                        .ip(ipMap(jinhongAccounts.getAccount()))
                        .operate(RspConstants.LOGIN)
                        .createTime(new DateTime(insertDay).plusMinutes(3).toDate()).build());
                if(isAddWords && wordLeng <= words.size() - 1) {
                    for (int logIndex = 0; logIndex < dayLogNum; logIndex++) {
                        Date insertDatePlus = new DateTime(insertDay).plusSeconds(GenerateLogUtil.dayAdd() * 2).toDate();
                        jinhongWords.add(JinhongWords.builder().word(words.get(wordLeng)).createTime(insertDatePlus).
                                opAccount(jinhongAccounts.getAccount()).
                                opNick(jinhongAccounts.getNick()).build());
                        visitLog.add(JinhongManageLog.builder().nick(jinhongAccounts.getNick())
                                .account(jinhongAccounts.getAccount())
                                .result(RspConstants.SUCCESS).msg(RspConstants.INSERT_WORD.replaceAll("\\{a\\}", words.get(wordLeng)))
                                .module(RspConstants.WORD)
                                .ip(ipMap(jinhongAccounts.getAccount()))
                                .operate(RspConstants.INSERT_WORD_OPERATE)
                                .createTime(insertDatePlus).build());
                        wordLeng++;
                    }
                }
                visitLog.add(JinhongManageLog.builder().nick(jinhongAccounts.getNick())
                        .account(jinhongAccounts.getAccount())
                        .result(RspConstants.SUCCESS).msg(RspConstants.LOGOUT_SUCCESS)
                        .module(RspConstants.LOGIN)
                        .ip(ipMap(jinhongAccounts.getAccount()))
                        .operate(RspConstants.LOGOUT)
                        .createTime(new DateTime(insertDay).plusMinutes(3).toDate()).build());
                beginDate = new DateTime(beginDate).plusDays(dayAdd).toDate();
                manageLogMapper.insertListSelective(visitLog.get(0), visitLog);
                wordsMapper.insertListSelective(jinhongWords.get(0), jinhongWords);
                Thread.sleep(100);
            } catch (Exception e) {
                logger.warn("addDayDate error", e);
                break;
            }
        }
    }


    public String ipMap(String account) {
        switch (account) {
            case "wuqy":
                return "58.248.229.157";
            case "zhihao":
                return "58.61.158.46";
            default:
                return "58.248.229.148";
        }
    }
    /**
     * 获取敏感词库
     * @return
     * @throws IOException
     */
    public List<String> getWordsConfig() {
        Resource resource = resourceLoader.getResource("classpath:word.txt");
        List<String> wordList = Lists.newArrayList();
        try (
            InputStream is = resource.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        ){
            String data = null;
            while((data = br.readLine()) != null) {
                wordList.add(data);
            }
        } catch (Exception e) {
            logger.warn("getWordsConfig error", e);
        }
        return wordList;
    }
}
