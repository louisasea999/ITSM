package com.yum.itsm.ddtalk.busi.entity;

import java.util.ArrayList;
import java.util.List;

public class DistrictGroupMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistrictGroupMapExample() {
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

        public Criteria andDistrictGroupIdIsNull() {
            addCriterion("district_group_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdIsNotNull() {
            addCriterion("district_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdEqualTo(Long value) {
            addCriterion("district_group_id =", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdNotEqualTo(Long value) {
            addCriterion("district_group_id <>", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdGreaterThan(Long value) {
            addCriterion("district_group_id >", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("district_group_id >=", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdLessThan(Long value) {
            addCriterion("district_group_id <", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("district_group_id <=", value, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdIn(List<Long> values) {
            addCriterion("district_group_id in", values, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdNotIn(List<Long> values) {
            addCriterion("district_group_id not in", values, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdBetween(Long value1, Long value2) {
            addCriterion("district_group_id between", value1, value2, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("district_group_id not between", value1, value2, "districtGroupId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Long value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Long value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Long value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Long value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Long value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Long value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Long> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Long> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Long value1, Long value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Long value1, Long value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdIsNull() {
            addCriterion("sup_project_group_id is null");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdIsNotNull() {
            addCriterion("sup_project_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdEqualTo(Long value) {
            addCriterion("sup_project_group_id =", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdNotEqualTo(Long value) {
            addCriterion("sup_project_group_id <>", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdGreaterThan(Long value) {
            addCriterion("sup_project_group_id >", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sup_project_group_id >=", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdLessThan(Long value) {
            addCriterion("sup_project_group_id <", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("sup_project_group_id <=", value, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdIn(List<Long> values) {
            addCriterion("sup_project_group_id in", values, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdNotIn(List<Long> values) {
            addCriterion("sup_project_group_id not in", values, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdBetween(Long value1, Long value2) {
            addCriterion("sup_project_group_id between", value1, value2, "supProjectGroupId");
            return (Criteria) this;
        }

        public Criteria andSupProjectGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("sup_project_group_id not between", value1, value2, "supProjectGroupId");
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