package com.wuqy.common.vo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * @author susy
 */
@Builder
@AllArgsConstructor
public class BaseView<T> {
    /**
     * 0成功；-2未登录；1失败；2异常
     */
    protected int code;

    /**
     * 返回码提示文字
     */
    protected String msg;

    /**
     * 登录账户
     */
    private String account;

    /**
     * 登录ticket
     */
    private String ticket;

    /**
     * 用户名
     */
    private String nick;

    /**
     * 返回结构体
     */
    protected T data;

    @JsonIgnore
    protected LogData log = new LogData();

    public BaseView() {
        this.code = RspConstants.SUCCESS;
        this.msg = RspConstants.SUCCESS_MSG;
    }

    public BaseView(T data) {
        this();
        this.data = data;
    }

    public BaseView(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseView(int code, String msg, int result, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return the {@link #code}
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the {@link #code} to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the {@link #msg}
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the {@link #msg} to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
    /**
     * @return the {@link #data}
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the {@link #data} to set
     */
    public void setData(T data) {
        this.data = data;
    }

    public LogData getLog() {
        return log;
    }

    public void setLog(LogData log) {
        this.log = log;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "BaseView{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", log=" + log +
                ", account=" + account +
                ", nick=" + nick +
                '}';
    }

    @Builder
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogData {
        /**
         * 具体操作消息：登录成功、账号或密码错误、注销成功、修改关键词、新增关键词、删除关键词
         */
        private String msg;

        /**
         * 结果：0成功、1失败、2异常
         */
        private Integer result;

        private String account;

        private String nick;
    }
}
