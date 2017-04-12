package com.yum.itsm.ddtalk.common.service;

import java.util.List;

import com.yum.itsm.ddtalk.common.entity.Department;

public interface DDTalkService {
	String getToken();
	
	List<Department> getDepartmentList();
}
