package com.wuqy.common.entity.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JinhongWordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     *  id,所属表字段为jinhong_words.id
     */
    private Integer id;

    /**
     *  关键词,所属表字段为jinhong_words.word
     */
    private String word;

    private String wordRange;

    /**
     *  操作人,所属表字段为jinhong_words.op_account
     */
    private String opAccount;

    private String opAccountRange;

    /**
     *  操作昵称,所属表字段为jinhong_words.op_nick
     */
    private String opNick;

    private String opNickRange;

    /**
     *  创建时间,所属表字段为jinhong_words.create_time
     */
    private Date createTime;

    private Date createTimeRange1;

    private Date createTimeRange2;

    private String extracClause;

    private String extracSelectColunm;

    private String extracTable;

    protected Long limitStart;

    protected Long limitEnd;

    public JinhongWordsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

    public String getWordRange() {
        return wordRange;
    }

    public void setWordRange(String wordRange) {
        this.wordRange = wordRange == null ? null : wordRange.trim();
    }

    public String getOpAccount() {
        return opAccount;
    }

    public void setOpAccount(String opAccount) {
        this.opAccount = opAccount == null ? null : opAccount.trim();
    }

    public String getOpAccountRange() {
        return opAccountRange;
    }

    public void setOpAccountRange(String opAccountRange) {
        this.opAccountRange = opAccountRange == null ? null : opAccountRange.trim();
    }

    public String getOpNick() {
        return opNick;
    }

    public void setOpNick(String opNick) {
        this.opNick = opNick == null ? null : opNick.trim();
    }

    public String getOpNickRange() {
        return opNickRange;
    }

    public void setOpNickRange(String opNickRange) {
        this.opNickRange = opNickRange == null ? null : opNickRange.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTimeRange1() {
        return createTimeRange1;
    }

    public void setCreateTimeRange1(Date createTimeRange1) {
        this.createTimeRange1 = createTimeRange1;
    }

    public Date getCreateTimeRange2() {
        return createTimeRange2;
    }

    public void setCreateTimeRange2(Date createTimeRange2) {
        this.createTimeRange2 = createTimeRange2;
    }

    public String getExtracClause() {
        return extracClause;
    }

    public void setExtracClause(String extracClause) {
        this.extracClause = extracClause == null ? null : extracClause.trim();
    }

    public String getExtracSelectColunm() {
        return extracSelectColunm;
    }

    public void setExtracSelectColunm(String extracSelectColunm) {
        this.extracSelectColunm = extracSelectColunm == null ? null : extracSelectColunm.trim();
    }

    public String getExtracTable() {
        return extracTable;
    }

    public void setExtracTable(String extracTable) {
        this.extracTable = extracTable == null ? null : extracTable.trim();
    }

    public void setLimitStart(Long limitStart) {
        this.limitStart=limitStart;
    }

    public Long getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Long limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Long getLimitEnd() {
        return limitEnd;
    }

    public void limit(Long limitStart, Long limitEnd) {
        this.limitStart = limitStart;
        this.limitEnd = limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWordIsNull() {
            addCriterion("word is null");
            return (Criteria) this;
        }

        public Criteria andWordIsNotNull() {
            addCriterion("word is not null");
            return (Criteria) this;
        }

        public Criteria andWordEqualTo(String value) {
            addCriterion("word =", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotEqualTo(String value) {
            addCriterion("word <>", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThan(String value) {
            addCriterion("word >", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThanOrEqualTo(String value) {
            addCriterion("word >=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThan(String value) {
            addCriterion("word <", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThanOrEqualTo(String value) {
            addCriterion("word <=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLike(String value) {
            addCriterion("word like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotLike(String value) {
            addCriterion("word not like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordIn(List<String> values) {
            addCriterion("word in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotIn(List<String> values) {
            addCriterion("word not in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordBetween(String value1, String value2) {
            addCriterion("word between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotBetween(String value1, String value2) {
            addCriterion("word not between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andOpAccountIsNull() {
            addCriterion("op_account is null");
            return (Criteria) this;
        }

        public Criteria andOpAccountIsNotNull() {
            addCriterion("op_account is not null");
            return (Criteria) this;
        }

        public Criteria andOpAccountEqualTo(String value) {
            addCriterion("op_account =", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountNotEqualTo(String value) {
            addCriterion("op_account <>", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountGreaterThan(String value) {
            addCriterion("op_account >", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountGreaterThanOrEqualTo(String value) {
            addCriterion("op_account >=", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountLessThan(String value) {
            addCriterion("op_account <", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountLessThanOrEqualTo(String value) {
            addCriterion("op_account <=", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountLike(String value) {
            addCriterion("op_account like", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountNotLike(String value) {
            addCriterion("op_account not like", value, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountIn(List<String> values) {
            addCriterion("op_account in", values, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountNotIn(List<String> values) {
            addCriterion("op_account not in", values, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountBetween(String value1, String value2) {
            addCriterion("op_account between", value1, value2, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpAccountNotBetween(String value1, String value2) {
            addCriterion("op_account not between", value1, value2, "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpNickIsNull() {
            addCriterion("op_nick is null");
            return (Criteria) this;
        }

        public Criteria andOpNickIsNotNull() {
            addCriterion("op_nick is not null");
            return (Criteria) this;
        }

        public Criteria andOpNickEqualTo(String value) {
            addCriterion("op_nick =", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickNotEqualTo(String value) {
            addCriterion("op_nick <>", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickGreaterThan(String value) {
            addCriterion("op_nick >", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickGreaterThanOrEqualTo(String value) {
            addCriterion("op_nick >=", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickLessThan(String value) {
            addCriterion("op_nick <", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickLessThanOrEqualTo(String value) {
            addCriterion("op_nick <=", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickLike(String value) {
            addCriterion("op_nick like", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickNotLike(String value) {
            addCriterion("op_nick not like", value, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickIn(List<String> values) {
            addCriterion("op_nick in", values, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickNotIn(List<String> values) {
            addCriterion("op_nick not in", values, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickBetween(String value1, String value2) {
            addCriterion("op_nick between", value1, value2, "opNick");
            return (Criteria) this;
        }

        public Criteria andOpNickNotBetween(String value1, String value2) {
            addCriterion("op_nick not between", value1, value2, "opNick");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andWordLikeInsensitive(String value) {
            addCriterion("upper(word) like", value.toUpperCase(), "word");
            return (Criteria) this;
        }

        public Criteria andOpAccountLikeInsensitive(String value) {
            addCriterion("upper(op_account) like", value.toUpperCase(), "opAccount");
            return (Criteria) this;
        }

        public Criteria andOpNickLikeInsensitive(String value) {
            addCriterion("upper(op_nick) like", value.toUpperCase(), "opNick");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}