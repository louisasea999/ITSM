package com.yum.itsm.ddtalk.busi.entity;

public class DeskRobotMap {
    private Integer deskRobotId;

    private String serviceDeskName;

    private String customRobotToken;

    private String jiraRobotToken;

    private String remark;

    public Integer getDeskRobotId() {
        return deskRobotId;
    }

    public void setDeskRobotId(Integer deskRobotId) {
        this.deskRobotId = deskRobotId;
    }

    public String getServiceDeskName() {
        return serviceDeskName;
    }

    public void setServiceDeskName(String serviceDeskName) {
        this.serviceDeskName = serviceDeskName == null ? null : serviceDeskName.trim();
    }

    public String getCustomRobotToken() {
        return customRobotToken;
    }

    public void setCustomRobotToken(String customRobotToken) {
        this.customRobotToken = customRobotToken == null ? null : customRobotToken.trim();
    }

    public String getJiraRobotToken() {
        return jiraRobotToken;
    }

    public void setJiraRobotToken(String jiraRobotToken) {
        this.jiraRobotToken = jiraRobotToken == null ? null : jiraRobotToken.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}