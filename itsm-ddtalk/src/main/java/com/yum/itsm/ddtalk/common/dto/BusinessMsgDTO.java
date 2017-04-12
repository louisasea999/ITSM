package com.yum.itsm.ddtalk.common.dto;

public class BusinessMsgDTO extends MsgDTO {

	private Object data = null;
	private Integer total = 0;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
