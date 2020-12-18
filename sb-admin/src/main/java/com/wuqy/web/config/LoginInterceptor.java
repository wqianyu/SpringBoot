package com.wuqy.web.config;

import com.wuqy.common.entity.content.JinhongAccount;
import com.wuqy.common.vo.BaseView;
import com.wuqy.common.vo.RspConstants;
import com.wuqy.web.util.LoginUtils;
import com.wuqy.web.util.SendMsgUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final String LOGIN = "/account/login";
    private final String VISIT = "/visit/insert";
    private final String WORD = "/word/list";
    private final String JS = ".js";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.indexOf(LOGIN) > -1 || uri.indexOf(VISIT) > -1
                || uri.indexOf(WORD) > -1 || uri.endsWith(JS)) {
            return true;
        }
        JinhongAccount account = LoginUtils.getUser(request);
        if(null != account) {
            return true;
        } else {
            BaseView baseView = BaseView.builder().code(RspConstants.UN_LOGIN).msg(RspConstants.UN_LOGIN_MSG).build();
            SendMsgUtil.sendJsonMessage(response, baseView);
            return false;
        }
    }
}
