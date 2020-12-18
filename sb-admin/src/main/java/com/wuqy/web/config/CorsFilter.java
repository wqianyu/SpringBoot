package com.wuqy.web.config;

import com.wuqy.web.util.LoginUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 另一种跨域配置方式
 */
@Component
public class CorsFilter implements Filter {

    @Value("${spring.profiles.active}")
    private String profile;

    private final String TEST = "test";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
//        if(StringUtils.isNotBlank(profile) && TEST.equals(profile)) {
        LoginUtils.setCors(response);
//        }
        chain.doFilter(req, res);
    }
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}
