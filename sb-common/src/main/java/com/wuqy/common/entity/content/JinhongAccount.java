package com.wuqy.common.entity.content;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class JinhongAccount {
    /**
     *  id,所属表字段为jinhong_account.id
     */
    private Integer id;

    /**
     *  账号名,所属表字段为jinhong_account.account
     */
    private String account;

    /**
     *  密码salt,所属表字段为jinhong_account.salt
     */
    private String salt;

    /**
     *  密码,所属表字段为jinhong_account.password
     */
    @JsonIgnore
    private String password;

    /**
     *  昵称,所属表字段为jinhong_account.nick
     */
    private String nick;

    /**
     *  创建时间,所属表字段为jinhong_account.create_time
     */
    private Date createTime;

    private String ticket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", salt=").append(salt);
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
        JinhongAccount other = (JinhongAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNick() == null ? other.getNick() == null : this.getNick().equals(other.getNick()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNick() == null) ? 0 : getNick().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public JinhongAccount() {
        
    }

    private JinhongAccount(Builder builder) {
        setId(builder.id);

        setAccount(builder.account);

        setSalt(builder.salt);

        setPassword(builder.password);

        setNick(builder.nick);

        setCreateTime(builder.createTime);

    }

    public static class Builder {
        /**
         *  id,所属表字段为jinhong_account.id
         */
        private Integer id;

        /**
         *  账号名,所属表字段为jinhong_account.account
         */
        private String account;

        /**
         *  密码salt,所属表字段为jinhong_account.salt
         */
        private String salt;

        /**
         *  密码,所属表字段为jinhong_account.password
         */
        private String password;

        /**
         *  昵称,所属表字段为jinhong_account.nick
         */
        private String nick;

        /**
         *  创建时间,所属表字段为jinhong_account.create_time
         */
        private Date createTime;

        public Builder id(Integer id) {
            this.id = id; return this;
        }

        public Builder account(String account) {
            this.account = account; return this;
        }

        public Builder salt(String salt) {
            this.salt = salt; return this;
        }

        public Builder password(String password) {
            this.password = password; return this;
        }

        public Builder nick(String nick) {
            this.nick = nick; return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime; return this;
        }

        public JinhongAccount build() {
            return new JinhongAccount(this);
        }
    }
}