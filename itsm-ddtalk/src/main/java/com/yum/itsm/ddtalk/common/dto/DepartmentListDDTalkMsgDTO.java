package com.yum.itsm.ddtalk.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.yum.itsm.ddtalk.common.entity.Department;

public class DepartmentListDDTalkMsgDTO extends DDTalkMsgDTO {
	private List<Department> department;

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	
//	private String department;
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
}
