package com.yum.itsm.ddtalk.busi.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusiMsgDTO {
	public final static String STATUS_OK = "ok";
	public final static String STATUS_FAIL = "fail";
	
	private String status = STATUS_OK;// fail
	private String message = "";
	private Object data = null;
	private Integer total = 0;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
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

	@Override
	public String toString() {
		return "MsgDTO [status=" + getStatus() + ", message=" + getMessage() + ", data=" + getData() + "]";
	}

}
