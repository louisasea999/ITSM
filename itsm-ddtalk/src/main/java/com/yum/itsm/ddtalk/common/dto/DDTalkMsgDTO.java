package com.yum.itsm.ddtalk.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

public class DDTalkMsgDTO {
	public static final String MSG_OK = "ok";
	public static final Integer CODE_OK = 0;
	
	public String errmsg = MSG_OK;
	public Integer errcode = CODE_OK;

	public String getErrMsg() {
		return errmsg;
	}

	public void setErrMsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrCode() {
		return errcode;
	}

	public void setErrCode(Integer errcode) {
		this.errcode = errcode;
	}
}
