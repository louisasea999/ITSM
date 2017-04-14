package com.yum.itsm.ddtalk.busi.entity;

import java.util.List;

public class DistrictInfo {
    private Long districtId;

    private String districtName;
    
    private List<SupProjectGroup> supProjectGroups;
    
    private List<DiningRoom> diningRomes;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

	public List<DiningRoom> getDiningRomes() {
		return diningRomes;
	}

	public void setDiningRomes(List<DiningRoom> diningRomes) {
		this.diningRomes = diningRomes;
	}

	public List<SupProjectGroup> getSupProjectGroups() {
		return supProjectGroups;
	}

	public void setSupProjectGroups(List<SupProjectGroup> supProjectGroups) {
		this.supProjectGroups = supProjectGroups;
	}
}