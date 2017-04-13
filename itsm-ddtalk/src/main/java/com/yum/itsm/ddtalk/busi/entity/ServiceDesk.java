package com.yum.itsm.ddtalk.busi.entity;

import java.util.List;

public class ServiceDesk {
    private Integer serviceDeskId;

    private String serviceDeskName;

    private Integer supProjectGroupId;

    private String remark;
    
    private List<EmpleeInfo> empleeInfo;

    public Integer getServiceDeskId() {
        return serviceDeskId;
    }

    public void setServiceDeskId(Integer serviceDeskId) {
        this.serviceDeskId = serviceDeskId;
    }

    public String getServiceDeskName() {
        return serviceDeskName;
    }

    public void setServiceDeskName(String serviceDeskName) {
        this.serviceDeskName = serviceDeskName == null ? null : serviceDeskName.trim();
    }

    public Integer getSupProjectGroupId() {
        return supProjectGroupId;
    }

    public void setSupProjectGroupId(Integer supProjectGroupId) {
        this.supProjectGroupId = supProjectGroupId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<EmpleeInfo> getEmpleeInfo() {
		return empleeInfo;
	}

	public void setEmpleeInfo(List<EmpleeInfo> empleeInfo) {
		this.empleeInfo = empleeInfo;
	}
}