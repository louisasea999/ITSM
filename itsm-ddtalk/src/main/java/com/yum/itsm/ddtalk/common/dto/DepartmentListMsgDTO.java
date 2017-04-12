package com.yum.itsm.ddtalk.common.dto;

import java.util.List;

import com.yum.itsm.ddtalk.common.entity.Department;

public class DepartmentListMsgDTO extends MsgDTO {
	private List<Department> departmentList;

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
}
