package com.wuqy.web.controller.login;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.entity.content.JinhongAccountExample;
import com.wuqy.common.log.ManagerLog;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.service.account.AccountService;
import com.wuqy.web.controller.BaseController;
import com.wuqy.web.util.LoginUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 登录相关
 * @author wuqy
 * 2020-11-10
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 登录
     * code=0成功，account=账号，nick=用户名
     * code=1失败，msg=账号或密码错误
     * code=2异常，msg=异常
     * @param request
     * @param account
     * @param password
     * @return
     */
    @ManagerLog(module="登录", operate = "登录")
    @RequestMapping("/login")
    @ResponseBody
    public BaseView login(HttpServletRequest request, String account, String password) {
        try {
            String nick = account;
            JinhongAccountExample example = new JinhongAccountExample();
            if (StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password)) {
                example.setAccount(account);
                List<JinhongAccount> list = accountService.list(example);
                if (CollectionUtils.isNotEmpty(list)) {
                    nick = list.get(0).getNick();
                    if(password.equals(list.get(0).getPassword())) {
                        LoginUtils.storeUser(request, list.get(0));
                        //页面获取太快，有可能拿不到登录态，延迟下
                        Thread.sleep(50);
                        return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).ticket(list.get(0).getTicket()).account(list.get(0).getAccount()).nick(list.get(0).getNick()).
                                log(logBuilder(list.get(0).getAccount(), list.get(0).getNick(), RspConstants.SUCCESS, RspConstants.LOGIN_SUCCESS)).build();
                    }
                }
            }
            return BaseView.builder().code(RspConstants.FAIL).msg(RspConstants.LOGIN_FAIL).
                    log(logBuilder(account, nick, RspConstants.FAIL, RspConstants.LOGIN_FAIL)).build();
        } catch (Exception e) {
            logger.warn("login error account:{}", account, e);
            return BaseView.builder().code(RspConstants.EXCEPTION).msg(RspConstants.EXCEPTION_MSG).
                    log(logBuilder(account, account, RspConstants.EXCEPTION, "")).build();
        }
    }

    /**
     * 注销
     * 成功code=0
     * @param request
     * @return
     */
    @ManagerLog(module="登录", operate = "注销")
    @RequestMapping("/logout")
    @ResponseBody
    public BaseView logout(HttpServletRequest request) {
        JinhongAccount account = LoginUtils.getUser(request);
        if(null != account) {
            LoginUtils.logout(request);
            return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.SUCCESS_MSG).
                    log(logBuilder(account.getAccount(), account.getNick(), RspConstants.SUCCESS, RspConstants.LOGOUT_SUCCESS)).
                    build();
        } else {
            return BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).
                    build();
        }
    }

    /**
     * 获取用户登录信息
     * 未登录code=-2
     * 登录中code=0，account=账号，nick=用户名
     * @param request
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public BaseView getUserInfo(HttpServletRequest request) {
        JinhongAccount account = LoginUtils.getUser(request);
        if(null != account) {
            return BaseView.builder().code(RspConstants.SUCCESS).msg(RspConstants.LOGIN_MSG).
                    account(account.getAccount()).
                    nick(account.getNick()).
                    build();
        } else {
            return BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).
                    build();
        }
    }
}
