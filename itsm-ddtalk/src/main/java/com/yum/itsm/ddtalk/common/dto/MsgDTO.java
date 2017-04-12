package com.yum.itsm.ddtalk.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MsgDTO {
	public static final String MSG_OK = "ok";
	public static final Integer CODE_OK = 0;
	
	public String errmsg = MSG_OK;
	
	public Integer errcode = CODE_OK;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
}
