package com.yum.itsm.ddtalk.busi.entity;

import java.util.ArrayList;
import java.util.List;

public class EmpleeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpleeInfoExample() {
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

        public Criteria andEmpleeIdIsNull() {
            addCriterion("emplee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdIsNotNull() {
            addCriterion("emplee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdEqualTo(String value) {
            addCriterion("emplee_id =", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdNotEqualTo(String value) {
            addCriterion("emplee_id <>", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdGreaterThan(String value) {
            addCriterion("emplee_id >", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdGreaterThanOrEqualTo(String value) {
            addCriterion("emplee_id >=", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdLessThan(String value) {
            addCriterion("emplee_id <", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdLessThanOrEqualTo(String value) {
            addCriterion("emplee_id <=", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdLike(String value) {
            addCriterion("emplee_id like", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdNotLike(String value) {
            addCriterion("emplee_id not like", value, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdIn(List<String> values) {
            addCriterion("emplee_id in", values, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdNotIn(List<String> values) {
            addCriterion("emplee_id not in", values, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdBetween(String value1, String value2) {
            addCriterion("emplee_id between", value1, value2, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeIdNotBetween(String value1, String value2) {
            addCriterion("emplee_id not between", value1, value2, "empleeId");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameIsNull() {
            addCriterion("emplee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameIsNotNull() {
            addCriterion("emplee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameEqualTo(String value) {
            addCriterion("emplee_name =", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameNotEqualTo(String value) {
            addCriterion("emplee_name <>", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameGreaterThan(String value) {
            addCriterion("emplee_name >", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameGreaterThanOrEqualTo(String value) {
            addCriterion("emplee_name >=", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameLessThan(String value) {
            addCriterion("emplee_name <", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameLessThanOrEqualTo(String value) {
            addCriterion("emplee_name <=", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameLike(String value) {
            addCriterion("emplee_name like", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameNotLike(String value) {
            addCriterion("emplee_name not like", value, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameIn(List<String> values) {
            addCriterion("emplee_name in", values, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameNotIn(List<String> values) {
            addCriterion("emplee_name not in", values, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameBetween(String value1, String value2) {
            addCriterion("emplee_name between", value1, value2, "empleeName");
            return (Criteria) this;
        }

        public Criteria andEmpleeNameNotBetween(String value1, String value2) {
            addCriterion("emplee_name not between", value1, value2, "empleeName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIsNull() {
            addCriterion("service_desk_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIsNotNull() {
            addCriterion("service_desk_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdEqualTo(Long value) {
            addCriterion("service_desk_id =", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotEqualTo(Long value) {
            addCriterion("service_desk_id <>", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdGreaterThan(Long value) {
            addCriterion("service_desk_id >", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_desk_id >=", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdLessThan(Long value) {
            addCriterion("service_desk_id <", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdLessThanOrEqualTo(Long value) {
            addCriterion("service_desk_id <=", value, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdIn(List<Long> values) {
            addCriterion("service_desk_id in", values, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotIn(List<Long> values) {
            addCriterion("service_desk_id not in", values, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdBetween(Long value1, Long value2) {
            addCriterion("service_desk_id between", value1, value2, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskIdNotBetween(Long value1, Long value2) {
            addCriterion("service_desk_id not between", value1, value2, "serviceDeskId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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