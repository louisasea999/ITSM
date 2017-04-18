package com.yum.itsm.ddtalk.busi.service;

import java.util.List;

import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;

public interface VendorInfoService {
	List<SupProjectGroup> getDeptsFromDDTalk();
	
	List<SupProjectGroup> getDeptsFromDB();
	
	SupProjectGroup getDeptFromDDTalk(Long id);
	
	SupProjectGroup getDeptFromDB(Long id);
	
	void updateSupProjectGroupInfo();
	
	void sendMsgByRobot(String issueKey, String deskName, String title, String text);
}
