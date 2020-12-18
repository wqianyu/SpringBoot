package com.wuqy.common.entity.content;

public class JinhongHistory {
    /**
     *  id,所属表字段为jinhong_history.id
     */
    private Integer id;

    /**
     *  页面地址,所属表字段为jinhong_history.url
     */
    private String url;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
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
        JinhongHistory other = (JinhongHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public JinhongHistory() {
        
    }

    private JinhongHistory(Builder builder) {
        setId(builder.id);

        setUrl(builder.url);

    }

    public static class Builder {
        /**
         *  id,所属表字段为jinhong_history.id
         */
        private Integer id;

        /**
         *  页面地址,所属表字段为jinhong_history.url
         */
        private String url;

        public Builder id(Integer id) {
            this.id = id; return this;
        }

        public Builder url(String url) {
            this.url = url; return this;
        }

        public JinhongHistory build() {
            return new JinhongHistory(this);
        }
    }
}