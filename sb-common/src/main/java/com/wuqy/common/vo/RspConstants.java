package com.wuqy.common.vo;

/**
 * 常量
 * @author wuqy
 * 2020-11-10
 */
public class RspConstants {

    /**
     * 未登录
     */
    public static final int UN_LOGIN = -2;
    public static final int SUCCESS   = 0;
    /**
     * 失败
     */
    public static final int FAIL      = 1;
    /**
     * 成功
     */
    public static final int EXCEPTION = 2;

    public static final String EXCEPTION_MSG  = "异常";
    public static final String SUCCESS_MSG    = "success";
    public static final String LOGIN_MSG      = "登录中";
    public static final String LOGIN          = "登录";
    public static final String UN_LOGIN_MSG   = "未登录";
    public static final String LOGIN_SUCCESS  = "登录成功";
    public static final String LOGIN_FAIL     = "账号或密码错误";
    public static final String LOGOUT_SUCCESS = "注销成功";
    public static final String LOGOUT_FAIL    = "注销失败";
    public static final String LOGOUT         = "注销";

    public static final String UPDATE_WORD = "修改关键词'{a}'更新为'{b}'";
    public static final String INSERT_WORD = "新增关键词'{a}'";
    public static final String INSERT_WORD_OPERATE = "新增关键词";
    public static final String DELETE_WORD = "删除关键词'{a}'";
    public static final String WORD        = "关键词";
    public static final String EMPTY       = "数据为空";
    public static final String NOTEXIST    = "记录不存在";

    public static final String VISIT       = "访客";
}
