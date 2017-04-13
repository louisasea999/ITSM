package com.yum.itsm.ddtalk.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

public class AccessTokenDDTalkMsgDTO extends DDTalkMsgDTO {
	private String access_token;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
}
