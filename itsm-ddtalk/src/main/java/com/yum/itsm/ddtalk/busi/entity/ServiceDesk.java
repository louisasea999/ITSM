package com.yum.itsm.ddtalk.busi.entity;

import java.util.List;

public class ServiceDesk {
    private Long serviceDeskId;

    private String serviceDeskName;

    private Long supProjectGroupId;

    private String remark;
    
    private List<EmpleeInfo> empleeInfos;

    public Long getServiceDeskId() {
        return serviceDeskId;
    }

    public void setServiceDeskId(Long serviceDeskId) {
        this.serviceDeskId = serviceDeskId;
    }

    public String getServiceDeskName() {
        return serviceDeskName;
    }

    public void setServiceDeskName(String serviceDeskName) {
        this.serviceDeskName = serviceDeskName == null ? null : serviceDeskName.trim();
    }

    public Long getSupProjectGroupId() {
        return supProjectGroupId;
    }

    public void setSupProjectGroupId(Long supProjectGroupId) {
        this.supProjectGroupId = supProjectGroupId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<EmpleeInfo> getEmpleeInfos() {
		return empleeInfos;
	}

	public void setEmpleeInfos(List<EmpleeInfo> empleeInfos) {
		this.empleeInfos = empleeInfos;
	}
}