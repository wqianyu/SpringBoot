package com.wuqy.common.entity.content;

import java.util.Date;

public class JinhongWords {
    /**
     *  id,所属表字段为jinhong_words.id
     */
    private Integer id;

    /**
     *  关键词,所属表字段为jinhong_words.word
     */
    private String word;

    /**
     *  操作人,所属表字段为jinhong_words.op_account
     */
    private String opAccount;

    /**
     *  操作昵称,所属表字段为jinhong_words.op_nick
     */
    private String opNick;

    /**
     *  创建时间,所属表字段为jinhong_words.create_time
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getOpAccount() {
        return opAccount;
    }

    public void setOpAccount(String opAccount) {
        this.opAccount = opAccount == null ? null : opAccount.trim();
    }

    public String getOpNick() {
        return opNick;
    }

    public void setOpNick(String opNick) {
        this.opNick = opNick == null ? null : opNick.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", word=").append(word);
        sb.append(", opAccount=").append(opAccount);
        sb.append(", opNick=").append(opNick);
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
        JinhongWords other = (JinhongWords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWord() == null ? other.getWord() == null : this.getWord().equals(other.getWord()))
            && (this.getOpAccount() == null ? other.getOpAccount() == null : this.getOpAccount().equals(other.getOpAccount()))
            && (this.getOpNick() == null ? other.getOpNick() == null : this.getOpNick().equals(other.getOpNick()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWord() == null) ? 0 : getWord().hashCode());
        result = prime * result + ((getOpAccount() == null) ? 0 : getOpAccount().hashCode());
        result = prime * result + ((getOpNick() == null) ? 0 : getOpNick().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public JinhongWords() {
        
    }

    private JinhongWords(Builder builder) {
        setId(builder.id);

        setWord(builder.word);

        setOpAccount(builder.opAccount);

        setOpNick(builder.opNick);

        setCreateTime(builder.createTime);

    }

    public static class Builder {
        /**
         *  id,所属表字段为jinhong_words.id
         */
        private Integer id;

        /**
         *  关键词,所属表字段为jinhong_words.word
         */
        private String word;

        /**
         *  操作人,所属表字段为jinhong_words.op_account
         */
        private String opAccount;

        /**
         *  操作昵称,所属表字段为jinhong_words.op_nick
         */
        private String opNick;

        /**
         *  创建时间,所属表字段为jinhong_words.create_time
         */
        private Date createTime;

        public Builder id(Integer id) {
            this.id = id; return this;
        }

        public Builder word(String word) {
            this.word = word; return this;
        }

        public Builder opAccount(String opAccount) {
            this.opAccount = opAccount; return this;
        }

        public Builder opNick(String opNick) {
            this.opNick = opNick; return this;
        }

        public Builder createTime(Date createTime) {
            this.createTime = createTime; return this;
        }

        public JinhongWords build() {
            return new JinhongWords(this);
        }
    }
}