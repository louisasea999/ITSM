package com.yum.itsm.ddtalk.common.dto;

import java.util.List;

import com.yum.itsm.ddtalk.common.entity.DDTalkUser;

public class UserListDDTalkMsgDTO extends DDTalkMsgDTO {
	private List<DDTalkUser> userlist;

	public List<DDTalkUser> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<DDTalkUser> userlist) {
		this.userlist = userlist;
	}
}
