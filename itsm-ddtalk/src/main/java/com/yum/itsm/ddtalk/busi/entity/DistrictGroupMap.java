package com.yum.itsm.ddtalk.busi.entity;

public class DistrictGroupMap {
    private Long districtGroupId;

    private Long districtId;

    private Long supProjectGroupId;

    private String remark;

    public Long getDistrictGroupId() {
        return districtGroupId;
    }

    public void setDistrictGroupId(Long districtGroupId) {
        this.districtGroupId = districtGroupId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
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
}