package com.yum.itsm.ddtalk.busi.entity;

import java.util.List;

public class DiningRoom {
    private Long diningRoomId;

    private String diningRoomName;

    private Long districtId;
    
    private List<ServiceDesk> serviceDesks;

    public Long getDiningRoomId() {
        return diningRoomId;
    }

    public void setDiningRoomId(Long diningRoomId) {
        this.diningRoomId = diningRoomId;
    }

    public String getDiningRoomName() {
        return diningRoomName;
    }

    public void setDiningRoomName(String diningRoomName) {
        this.diningRoomName = diningRoomName == null ? null : diningRoomName.trim();
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

	public List<ServiceDesk> getServiceDesks() {
		return serviceDesks;
	}

	public void setServiceDesks(List<ServiceDesk> serviceDesks) {
		this.serviceDesks = serviceDesks;
	}
}