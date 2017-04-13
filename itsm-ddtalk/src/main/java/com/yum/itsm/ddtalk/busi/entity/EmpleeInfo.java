package com.yum.itsm.ddtalk.busi.entity;

public class EmpleeInfo {
    private Integer empleeId;

    private String empleeName;

    private Integer serviceDeskId;

    private String remark;

    public Integer getEmpleeId() {
        return empleeId;
    }

    public void setEmpleeId(Integer empleeId) {
        this.empleeId = empleeId;
    }

    public String getEmpleeName() {
        return empleeName;
    }

    public void setEmpleeName(String empleeName) {
        this.empleeName = empleeName == null ? null : empleeName.trim();
    }

    public Integer getServiceDeskId() {
        return serviceDeskId;
    }

    public void setServiceDeskId(Integer serviceDeskId) {
        this.serviceDeskId = serviceDeskId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}