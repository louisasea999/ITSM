package com.yum.itsm.ddtalk.busi.entity;

import java.util.ArrayList;
import java.util.List;

public class DeskRobotMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeskRobotMapExample() {
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

        public Criteria andDeskRobotIdIsNull() {
            addCriterion("desk_robot_id is null");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdIsNotNull() {
            addCriterion("desk_robot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdEqualTo(Integer value) {
            addCriterion("desk_robot_id =", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdNotEqualTo(Integer value) {
            addCriterion("desk_robot_id <>", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdGreaterThan(Integer value) {
            addCriterion("desk_robot_id >", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("desk_robot_id >=", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdLessThan(Integer value) {
            addCriterion("desk_robot_id <", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdLessThanOrEqualTo(Integer value) {
            addCriterion("desk_robot_id <=", value, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdIn(List<Integer> values) {
            addCriterion("desk_robot_id in", values, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdNotIn(List<Integer> values) {
            addCriterion("desk_robot_id not in", values, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdBetween(Integer value1, Integer value2) {
            addCriterion("desk_robot_id between", value1, value2, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andDeskRobotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("desk_robot_id not between", value1, value2, "deskRobotId");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameIsNull() {
            addCriterion("service_desk_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameIsNotNull() {
            addCriterion("service_desk_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameEqualTo(String value) {
            addCriterion("service_desk_name =", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameNotEqualTo(String value) {
            addCriterion("service_desk_name <>", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameGreaterThan(String value) {
            addCriterion("service_desk_name >", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_desk_name >=", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameLessThan(String value) {
            addCriterion("service_desk_name <", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameLessThanOrEqualTo(String value) {
            addCriterion("service_desk_name <=", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameLike(String value) {
            addCriterion("service_desk_name like", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameNotLike(String value) {
            addCriterion("service_desk_name not like", value, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameIn(List<String> values) {
            addCriterion("service_desk_name in", values, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameNotIn(List<String> values) {
            addCriterion("service_desk_name not in", values, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameBetween(String value1, String value2) {
            addCriterion("service_desk_name between", value1, value2, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andServiceDeskNameNotBetween(String value1, String value2) {
            addCriterion("service_desk_name not between", value1, value2, "serviceDeskName");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenIsNull() {
            addCriterion("custom_robot_token is null");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenIsNotNull() {
            addCriterion("custom_robot_token is not null");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenEqualTo(String value) {
            addCriterion("custom_robot_token =", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenNotEqualTo(String value) {
            addCriterion("custom_robot_token <>", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenGreaterThan(String value) {
            addCriterion("custom_robot_token >", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenGreaterThanOrEqualTo(String value) {
            addCriterion("custom_robot_token >=", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenLessThan(String value) {
            addCriterion("custom_robot_token <", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenLessThanOrEqualTo(String value) {
            addCriterion("custom_robot_token <=", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenLike(String value) {
            addCriterion("custom_robot_token like", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenNotLike(String value) {
            addCriterion("custom_robot_token not like", value, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenIn(List<String> values) {
            addCriterion("custom_robot_token in", values, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenNotIn(List<String> values) {
            addCriterion("custom_robot_token not in", values, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenBetween(String value1, String value2) {
            addCriterion("custom_robot_token between", value1, value2, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andCustomRobotTokenNotBetween(String value1, String value2) {
            addCriterion("custom_robot_token not between", value1, value2, "customRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenIsNull() {
            addCriterion("jira_robot_token is null");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenIsNotNull() {
            addCriterion("jira_robot_token is not null");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenEqualTo(String value) {
            addCriterion("jira_robot_token =", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenNotEqualTo(String value) {
            addCriterion("jira_robot_token <>", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenGreaterThan(String value) {
            addCriterion("jira_robot_token >", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenGreaterThanOrEqualTo(String value) {
            addCriterion("jira_robot_token >=", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenLessThan(String value) {
            addCriterion("jira_robot_token <", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenLessThanOrEqualTo(String value) {
            addCriterion("jira_robot_token <=", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenLike(String value) {
            addCriterion("jira_robot_token like", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenNotLike(String value) {
            addCriterion("jira_robot_token not like", value, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenIn(List<String> values) {
            addCriterion("jira_robot_token in", values, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenNotIn(List<String> values) {
            addCriterion("jira_robot_token not in", values, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenBetween(String value1, String value2) {
            addCriterion("jira_robot_token between", value1, value2, "jiraRobotToken");
            return (Criteria) this;
        }

        public Criteria andJiraRobotTokenNotBetween(String value1, String value2) {
            addCriterion("jira_robot_token not between", value1, value2, "jiraRobotToken");
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