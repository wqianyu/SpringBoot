package com.wuqy.web.controller.word;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongWords;
import com.wuqy.common.entity.content.JinhongWordsExample;
import com.wuqy.common.log.ManagerLog;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.Page;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.service.word.WordService;
import com.wuqy.web.controller.BaseController;
import com.wuqy.web.util.LoginUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 关键词相关
 * @author wuqy
 * 2020-11-10
 */
@RestController
@RequestMapping("/word")
public class WordController extends BaseController {

    @Autowired
    private WordService wordService;

    private static final int WORD_MAX = 50;

    /**
     * 新增关键词
     * @param request
     * @param word
     * @return
     */
    @ManagerLog(module="关键词", operate = "新增关键词")
    @RequestMapping("/insert")
    @ResponseBody
    public BaseView insert(HttpServletRequest request, String word) {
        if(StringUtils.isNotBlank(word)) {
            word = word.trim();
            JinhongAccount account = LoginUtils.getUser(request);
            if(null != account) {
                if(word.length()>WORD_MAX) {
                    return BaseView.builder().code(RspConstants.FAIL).msg("超出50个字符限制").
                            log(logBuilder(account.getAccount(), account.getNick(), RspConstants.FAIL, "超出50个字符限制:"+word)).
                            build();
                }
                JinhongWords entity = JinhongWords.builder().word(word).build();
                entity.setCreateTime(new Date());
                entity.setOpAccount(account.getAccount());
                entity.setOpNick(account.getNick());
                wordService.insert(entity);
                return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).
                        log(logBuilder(account.getAccount(), account.getNick(), RspConstants.SUCCESS, RspConstants.INSERT_WORD, entity.getWord())).
                        build();
            } else {
                return BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).build();
            }
        } else {
            return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.EMPTY).
                    build();
        }
    }

    /**
     * 删除关键词
     * @param request
     * @param id 关键词id
     * @return
     */
    @ManagerLog(module="关键词", operate = "删除关键词")
    @RequestMapping("/delete")
    @ResponseBody
    public BaseView delete(HttpServletRequest request, Integer id) {
        if(null != id && 0 != id.intValue()) {
            JinhongAccount account = LoginUtils.getUser(request);
            if(null != account) {
                JinhongWords word = wordService.getById(id);
                if(null != word) {
                    wordService.delete(id);
                    return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).
                            log(logBuilder(account.getAccount(), account.getNick(), RspConstants.SUCCESS, RspConstants.DELETE_WORD, word.getWord().trim()))
                            .build();
                } else {
                    return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.NOTEXIST+":"+id).
                            log(logBuilder(account.getAccount(),account.getNick(), RspConstants.FAIL, RspConstants.NOTEXIST+":"+id)).
                            build();
                }
            } else {
                return BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).build();
            }
        } else {
            return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.EMPTY).
                    build();
        }
    }

    /**
     * 修改关键词
     * @param request
     * @param id 关键词id
     * @param word 关键词
     * @return
     */
    @ManagerLog(module="关键词", operate = "修改关键词")
    @RequestMapping("/update")
    @ResponseBody
    public BaseView update(HttpServletRequest request, Integer id, String word) {
        if(null != id && StringUtils.isNotBlank(word)) {
            word = word.trim();
            JinhongAccount account = LoginUtils.getUser(request);
            if(null != account) {
                if(word.length()>WORD_MAX) {
                    return BaseView.builder().code(RspConstants.FAIL).msg("超出50个字符限制").
                            log(logBuilder(account.getAccount(), account.getNick(), RspConstants.FAIL, "超出50个字符限制:"+word.trim())).
                            build();
                }
                JinhongWords entity = wordService.getById(id);
                if(null != entity) {
                    String oldWord = entity.getWord();
                    entity.setWord(word);
                    entity.setOpAccount(account.getAccount());
                    entity.setOpNick(account.getNick());
                    entity.setCreateTime(new Date());
                    wordService.update(entity);
                    return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).
                            log(logBuilder(account.getAccount(), account.getNick(), RspConstants.SUCCESS, RspConstants.UPDATE_WORD, oldWord, word.trim()))
                            .build();
                } else {
                    return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.NOTEXIST+":"+id).
                            log(logBuilder(account.getAccount(),account.getNick(), RspConstants.FAIL, RspConstants.NOTEXIST+":"+id)).
                            build();
                }
            } else {
                return BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).build();
            }
        } else {
            return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.EMPTY).
                    build();
        }
    }

    /**
     * 关键词列表记录
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public BaseView<JinhongWords> pageData() {
        Page<JinhongWords> pageData = wordService.page(new JinhongWordsExample(), 1, 10000);
        return new BaseView(pageData);
    }

    /**
     * 敏感词
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseView list() {
        List<JinhongWords> list = wordService.select();
        List<String> listStr = list.stream().map(JinhongWords::getWord).collect(Collectors.toList());
        return new BaseView(String.join("|", listStr));
    }
}
