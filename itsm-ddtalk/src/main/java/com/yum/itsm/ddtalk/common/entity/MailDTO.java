package com.yum.itsm.ddtalk.common.entity;

import java.io.Serializable;
import java.util.List;

public class MailDTO implements Serializable{
	private static final long serialVersionUID = 1003118495782431812L;
	
	private List<String> toAddress;
	
	private List<String> toUserId;
	
	private String subject;
	
	private String context;

	public List<String> getToAddress() {
		return toAddress;
	}

	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}

	public List<String> getToUserId() {
		return toUserId;
	}

	public void setToUserId(List<String> toUserId) {
		this.toUserId = toUserId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
