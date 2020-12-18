package com.wuqy.common.entity.content;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class JinhongUserVisit {
    /**
     *  id,所属表字段为jinhong_user_visit.id
     */
    private Integer id;

    /**
     *  页面地址,所属表字段为jinhong_user_visit.url
     */
    private String url;

    /**
     *  ip地址,所属表字段为jinhong_user_visit.ip
     */
    private String ip;

    /**
     *  用户账号,所属表字段为jinhong_user_visit.account
     */
    private String account;

    /**
     *  用户昵称,所属表字段为jinhong_user_visit.nick
     */
    private String nick;

    /**
     *  创建时间,所属表字段为jinhong_user_visit.create_time
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", ip=").append(ip);
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
        JinhongUserVisit other = (JinhongUserVisit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public JinhongUserVisit() {
        
    }

    private JinhongUserVisit(Builder builder) {
        setId(builder.id);

        setUrl(builder.url);

        setIp(builder.ip);

        setAccount(builder.account);

        setNick(builder.nick);

        setCreateTime(builder.createTime);

    }

    public static class Builder {
        /**
         *  id,所属表字段为jinhong_user_visit.id
         */
        private Integer id;

        /**
         *  页面地址,所属表字段为jinhong_user_visit.url
         */
        private String url;

        /**
         *  ip地址,所属表字段为jinhong_user_visit.ip
         */
        private String ip;

        /**
         *  用户账号,所属表字段为jinhong_user_visit.account
         */
        private String account;

        /**
         *  用户昵称,所属表字段为jinhong_user_visit.nick
         */
        private String nick;

        /**
         *  创建时间,所属表字段为jinhong_user_visit.create_time
         */
        private Date createTime;

        public Builder id(Integer id) {
            this.id = id; return this;
        }

        public Builder url(String url) {
            this.url = url; return this;
        }

        public Builder ip(String ip) {
            this.ip = ip; return this;
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

        public JinhongUserVisit build() {
            return new JinhongUserVisit(this);
        }
    }
}