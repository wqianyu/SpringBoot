package com.wuqy.common.entity.content;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;

public class JinhongManageLog {
    /**
     *  id,所属表字段为jinhong_manage_log.id
     */
    private Integer id;

    /**
     *  模块：登录、关键词,所属表字段为jinhong_manage_log.module
     */
    private String module;

    /**
     *  ip地址,所属表字段为jinhong_manage_log.ip
     */
    private String ip;

    /**
     *  操作：登录、注销、新增关键词、删除关键词、修改关键词,所属表字段为jinhong_manage_log.operate
     */
    private String operate;

    /**
     *  具体操作消息：登录成功、账号或密码错误、注销成功、修改关键词、新增关键词、删除关键词,所属表字段为jinhong_manage_log.msg
     */
    private String msg;

    /**
     *  结果：0成功、1失败、2异常,所属表字段为jinhong_manage_log.result
     */
    @JsonIgnore
    private Integer result;

    private String resultStr;

    /**
     *  用户账号,所属表字段为jinhong_manage_log.account
     */
    private String account;

    /**
     *  用户昵称,所属表字段为jinhong_manage_log.nick
     */
    private String nick;

    /**
     *  创建时间,所属表字段为jinhong_manage_log.create_time
     */
    private Date createTime;

    @JsonIgnore
    private Date minTime;

    @JsonIgnore
    private Date maxTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    @JsonGetter("result")
    public String getResultStr() {
        switch (result) {
            case 0: return "成功";
            case 1: return "失败";
            case 2: return "异常";
            default: return "";
        }
    }

    @JsonSetter("result")
    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", module=").append(module);
        sb.append(", ip=").append(ip);
        sb.append(", operate=").append(operate);
        sb.append(", msg=").append(msg);
        sb.append(", result=").append(result);
        sb.append(", account=").append(account);
        sb.append(", nick=").append(nick);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        JinhongManageLog other = (JinhongManageLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getOperate() == null ? other.getOperate() == null : this.getOperate().equals(other.getOperate()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getOperate() == null) ? 0 : getOperate().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public JinhongManageLog() {
        
    }

    private JinhongManageLog(Builder builder) {
        setId(builder.id);

        setModule(builder.module);

        setIp(builder.ip);

        setOperate(builder.operate);

        setMsg(builder.msg);

        setResult(builder.result);

        setAccount(builder.account);

        setNick(builder.nick);

        setCreateTime(builder.createTime);

    }

    public static class Builder {
        /**
         *  id,所属表字段为jinhong_manage_log.id
         */
        private Integer id;

        /**
         *  模块：登录、关键词,所属表字段为jinhong_manage_log.module
         */
        private String module;

        /**
         *  ip地址,所属表字段为jinhong_manage_log.ip
         */
        private String ip;

        /**
         *  操作：登录、注销、新增关键词、删除关键词、修改关键词,所属表字段为jinhong_manage_log.operate
         */
        private String operate;

        /**
         *  具体操作消息：登录成功、账号或密码错误、注销成功、修改关键词、新增关键词、删除关键词,所属表字段为jinhong_manage_log.msg
         */
        private String msg;

        /**
         *  结果：0成功、1失败、2异常,所属表字段为jinhong_manage_log.result
         */
        private Integer result;

        /**
         *  用户账号,所属表字段为jinhong_manage_log.account
         */
        private String account;

        /**
         *  用户昵称,所属表字段为jinhong_manage_log.nick
         */
        private String nick;

        /**
         *  创建时间,所属表字段为jinhong_manage_log.create_time
         */
        private Date createTime;

        public Builder id(Integer id) {
            this.id = id; return this;
        }

        public Builder module(String module) {
            this.module = module; return this;
        }

        public Builder ip(String ip) {
            this.ip = ip; return this;
        }

        public Builder operate(String operate) {
            this.operate = operate; return this;
        }

        public Builder msg(String msg) {
            this.msg = msg; return this;
        }

        public Builder result(Integer result) {
            this.result = result; return this;
        }

        public Builder account(String account) {
            this.account = account; return this;
        }

        public Builder nick(String nick) {
            this.nick = nick; return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime; return this;
        }

        public JinhongManageLog build() {
            return new JinhongManageLog(this);
        }
    }
}