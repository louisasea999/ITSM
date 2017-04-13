package com.yum.itsm.ddtalk.common.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.yum.itsm.ddtalk.common.entity.DDTalkDepartment;

public class DepartmentListDDTalkMsgDTO extends DDTalkMsgDTO {
	private List<DDTalkDepartment> department;

	public List<DDTalkDepartment> getDepartment() {
		return department;
	}

	public void setDepartment(List<DDTalkDepartment> department) {
		this.department = department;
	}
}
