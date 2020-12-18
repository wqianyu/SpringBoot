package com.wuqy.service.visit;

import com.google.common.collect.Lists;
import com.wuqy.common.entity.content.JinhongHistory;
import com.wuqy.common.entity.content.JinhongUserVisit;
import com.wuqy.common.util.GenerateLogUtil;
import com.wuqy.persist.mapper.content.JinhongHistoryMapper;
import com.wuqy.persist.mapper.content.JinhongUserVisitMapper;
import com.wuqy.spider.service.CrawController;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class HistoryLogService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JinhongHistoryMapper historyMapper;

    @Autowired
    private JinhongUserVisitMapper visitLogMapper;

//    @Scheduled(initialDelay = 5000, fixedDelay = 3600000)
    public void refreshHistoryLog() {
        try {
            logger.info("refreshHistoryLog await");
            CrawController.countDownLatch.await();
            logger.info("refreshHistoryLog await finish");
            JinhongUserVisit userVisitExists = visitLogMapper.selectMinMaxTime();
            if (null == userVisitExists) {
                logger.info("refreshHistoryLog initial");
                //初始化3个月前开始添加
                addDayDate(new DateTime().minusDays(90).toDate(), new DateTime().minusDays(1).toDate());
                addDayDate(new DateTime().minusDays(90).toDate(), new DateTime().minusDays(1).toDate());
            } else if(null != userVisitExists.getMaxTime()) {
                logger.info("refreshHistoryLog add data:"+new DateTime(userVisitExists.getMaxTime()).toString("yyyy-MM-dd HH:mm:ss"));
                if(new DateTime(userVisitExists.getMaxTime()).plusDays(1).getMillis() < System.currentTimeMillis()) {
                    addDayDate(userVisitExists.getMaxTime(), new Date());
                }
            }
            logger.info("refreshHistoryLog save finish");
        } catch (Exception e) {
            logger.warn("refreshHistoryLog error", e);
        }
    }

    public void addDayDate(Date beginDate, Date endDate) {
        //每隔1-3天增加访问日志
        while(beginDate.getTime() < endDate.getTime()) {
            try {
                List<JinhongUserVisit> visitLog = Lists.newArrayList();
                int dayLogNum = GenerateLogUtil.dayLogNum();
                int dayAdd = GenerateLogUtil.dayAdd();
                String ip = GenerateLogUtil.randomIp();
                List<JinhongHistory> jinhongHistoryList = historyMapper.selectRandom(dayLogNum);
                for (int logIndex = 0; logIndex < dayLogNum; logIndex++) {
                    Date insertDay = GenerateLogUtil.randomTimeByDate(beginDate);
                    visitLog.add(JinhongUserVisit.builder().account("访客").nick("访客").
                            createTime(insertDay).url(jinhongHistoryList.get(logIndex).getUrl()).ip(ip).build());
                }
                beginDate = new DateTime(beginDate).plusDays(dayAdd).toDate();
                visitLogMapper.insertListSelective(visitLog.get(0), visitLog);
                Thread.sleep(100);
            } catch (Exception e) {
                logger.warn("addDayDate error", e);
                break;
            }
        }
    }
}
