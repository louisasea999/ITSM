package com.yum.itsm.ddtalk.busi.entity;

public class EmpleeInfo {
    private String empleeId;

    private String empleeName;

    private Long serviceDeskId;

    private String remark;

    public String getEmpleeId() {
        return empleeId;
    }

    public void setEmpleeId(String empleeId) {
        this.empleeId = empleeId == null ? null : empleeId.trim();
    }

    public String getEmpleeName() {
        return empleeName;
    }

    public void setEmpleeName(String empleeName) {
        this.empleeName = empleeName == null ? null : empleeName.trim();
    }

    public Long getServiceDeskId() {
        return serviceDeskId;
    }

    public void setServiceDeskId(Long serviceDeskId) {
        this.serviceDeskId = serviceDeskId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}