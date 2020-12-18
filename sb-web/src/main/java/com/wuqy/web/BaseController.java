package com.wuqy.web;

import com.wuqy.common.vo.BaseView;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    public static final String UNKNOWN = "unknown";

    public HttpServletRequest getHttpServletRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 公共错误提示json
     */
    protected BaseView renderErrorMsg(int code, String msg) {
        return new BaseView(code, msg);
    }

    protected BaseView renderData(Object obj) {
        return new BaseView(obj);
    }

    private final int TWO_WORD_LENGTH = 2;
    private final int ONE_WORD_LENGTH = 1;
}
