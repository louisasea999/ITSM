package com.yum.itsm.ddtalk.busi.entity.robot;

public class LinkMsg {
	private String msgtype = "link";
	private LinkContent link;
	
	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public LinkContent getLink() {
		return link;
	}

	public void setLink(LinkContent link) {
		this.link = link;
	}
}
