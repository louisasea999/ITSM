package com.yum.itsm.ddtalk.common.entity;

public class BusinessConditionDTO {

    private String columnName; // 规则名称,employee_credential_expire_date,contract_expire_date
    private Integer compareType; // 比较类型,1:大于,2:大于等于,3:等于,4:小于,5:小于等于,6:不等于
    private String optionType; // 属性类型,D:当天,M:本月,Y:本年(暂时可以不管)
    private Integer adjustment; // 调整值,经BA确认,正数表示之前几天,负数表示之后几天

    public String getColumnName() {

        return columnName;
    }

    public void setColumnName(String columnName) {

        this.columnName = columnName;
    }

    public Integer getCompareType() {

        return compareType;
    }

    public void setCompareType(Integer compareType) {

        this.compareType = compareType;
    }

    public String getOptionType() {

        return optionType;
    }

    public void setOptionType(String optionType) {

        this.optionType = optionType;
    }

    public Integer getAdjustment() {

        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {

        this.adjustment = adjustment;
    }

}
