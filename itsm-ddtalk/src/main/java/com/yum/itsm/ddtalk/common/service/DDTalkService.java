package com.yum.itsm.ddtalk.common.service;

import java.util.List;

import com.yum.itsm.ddtalk.common.entity.DDTalkDepartment;
import com.yum.itsm.ddtalk.common.entity.DDTalkUser;

public interface DDTalkService {
	String getToken();
	
	List<DDTalkDepartment> getDepartmentList();
	
	List<DDTalkUser> getUserList(Long departmentId);
}
