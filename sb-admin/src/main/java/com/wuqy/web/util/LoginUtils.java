package com.wuqy.web.util;

import com.google.common.collect.Maps;
import com.wuqy.common.entity.content.JinhongAccount;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Map;
import java.util.Random;

public class LoginUtils {

    public static final String UNKNOWN = "unknown";

    public static final String TICKET  = "ticket";

    /**
     * 不能用session，跨域
     * @param req
     * @return
     */
    public static JinhongAccount getUser(HttpServletRequest req) {
        return LOGIN_MAP.get(getTicket(req));
    }

    private static Map<String, JinhongAccount> LOGIN_MAP = Maps.newHashMap();

    public static void storeUser(HttpServletRequest req, JinhongAccount user) {
        if (user != null) {
            user.setTicket(generateTicket());
            LOGIN_MAP.put(user.getTicket(), user);
        }
    }

    public static void logout(HttpServletRequest req) {
        LOGIN_MAP.remove(getTicket(req));
    }

    public static String getSourceIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(StringUtils.isNotBlank(ip)){
            String[] split = ip.split(",");
            if (split.length >= 1) {
                ip = split[0];
            }
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static String getTicket(HttpServletRequest req) {
        String ticket = req.getParameter(TICKET);
        if(StringUtils.isBlank(ticket)) {
            ticket = req.getHeader(TICKET);
        }
        if(StringUtils.isBlank(ticket)) {
            ticket = "";
        }
        return ticket;
    }

    private static String generateTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append(Thread.currentThread().getName());
        sb.append(new Random().nextInt(10000));
        return Base64.getEncoder().encodeToString(sb.toString().getBytes());
    }

    public static void setCors(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    }
}
