package com.yum.itsm.ddtalk.busi.service;

import java.util.List;

import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;

public interface VendorInfoService {
	List<SupProjectGroup> getDeptsFromDDTalk();
	
	void ddTalkDeptUpdater();
}
