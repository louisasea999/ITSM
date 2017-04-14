package com.yum.itsm.ddtalk.busi.entity;

public class DiningDeskMap {
    private Long diningDeskId;

    private Long diningRoomId;

    private Long serviceDeskId;

    private String remark;

    public Long getDiningDeskId() {
        return diningDeskId;
    }

    public void setDiningDeskId(Long diningDeskId) {
        this.diningDeskId = diningDeskId;
    }

    public Long getDiningRoomId() {
        return diningRoomId;
    }

    public void setDiningRoomId(Long diningRoomId) {
        this.diningRoomId = diningRoomId;
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