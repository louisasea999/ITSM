package com.yum.itsm.ddtalk.busi.entity;

import java.util.List;

public class SupProjectGroup {
    private Integer supProjectGroupId;

    private String supProjectGroupName;

    private String remark;
    
    private List<ServiceDesk> serviceDesks;

    public Integer getSupProjectGroupId() {
        return supProjectGroupId;
    }

    public void setSupProjectGroupId(Integer supProjectGroupId) {
        this.supProjectGroupId = supProjectGroupId;
    }

    public String getSupProjectGroupName() {
        return supProjectGroupName;
    }

    public void setSupProjectGroupName(String supProjectGroupName) {
        this.supProjectGroupName = supProjectGroupName == null ? null : supProjectGroupName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<ServiceDesk> getServiceDesks() {
		return serviceDesks;
	}

	public void setServiceDesks(List<ServiceDesk> serviceDesks) {
		this.serviceDesks = serviceDesks;
	}
}