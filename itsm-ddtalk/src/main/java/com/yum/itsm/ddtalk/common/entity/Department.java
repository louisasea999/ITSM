package com.yum.itsm.ddtalk.common.entity;

public class Department {
	private Integer id;
	private Boolean createDeptGroup;
	private String name;
	private Boolean autoAddUser;
	private Integer parentid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getCreateDeptGroup() {
		return createDeptGroup;
	}
	public void setCreateDeptGroup(Boolean createDeptGroup) {
		this.createDeptGroup = createDeptGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAutoAddUser() {
		return autoAddUser;
	}
	public void setAutoAddUser(Boolean autoAddUser) {
		this.autoAddUser = autoAddUser;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
}
