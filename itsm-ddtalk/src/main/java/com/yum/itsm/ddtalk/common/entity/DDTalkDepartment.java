package com.yum.itsm.ddtalk.common.entity;

public class DDTalkDepartment {
	private Long id;
	private Boolean createDeptGroup;
	private String name;
	private Boolean autoAddUser;
	private Long parentid;
	private Long order;
	private Boolean deptHiding;
	private String deptPerimits;
	private String userPerimits;
	private Boolean outerDept;
	private String outerPermitDepts;
	private String outerPermitUsers;
	private String orgDeptOwner;
	private String deptManagerUseridList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public Boolean getDeptHiding() {
		return deptHiding;
	}
	public void setDeptHiding(Boolean deptHiding) {
		this.deptHiding = deptHiding;
	}
	public String getDeptPerimits() {
		return deptPerimits;
	}
	public void setDeptPerimits(String deptPerimits) {
		this.deptPerimits = deptPerimits;
	}
	public String getUserPerimits() {
		return userPerimits;
	}
	public void setUserPerimits(String userPerimits) {
		this.userPerimits = userPerimits;
	}
	public Boolean getOuterDept() {
		return outerDept;
	}
	public void setOuterDept(Boolean outerDept) {
		this.outerDept = outerDept;
	}
	public String getOuterPermitDepts() {
		return outerPermitDepts;
	}
	public void setOuterPermitDepts(String outerPermitDepts) {
		this.outerPermitDepts = outerPermitDepts;
	}
	public String getOuterPermitUsers() {
		return outerPermitUsers;
	}
	public void setOuterPermitUsers(String outerPermitUsers) {
		this.outerPermitUsers = outerPermitUsers;
	}
	public String getOrgDeptOwner() {
		return orgDeptOwner;
	}
	public void setOrgDeptOwner(String orgDeptOwner) {
		this.orgDeptOwner = orgDeptOwner;
	}
	public String getDeptManagerUseridList() {
		return deptManagerUseridList;
	}
	public void setDeptManagerUseridList(String deptManagerUseridList) {
		this.deptManagerUseridList = deptManagerUseridList;
	}
}
