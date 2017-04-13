package com.yum.itsm.ddtalk.busi.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.yum.itsm.ddtalk.common.entity.Department;

@XmlRootElement
public class DepartmentListBusiMsgDTO extends BusiMsgDTO {
	@XmlElement
	List<Department> data = null;
	
	public List<Department> getData() {
		return data;
	}

	public void setData(List<Department> data) {
		this.data = data;
	}
}
