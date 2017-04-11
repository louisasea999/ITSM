package com.yum.itsm.ddtalk.common.tree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTreeNode implements Node<SimpleTreeNode> {

	private Long nodeId = null;

	private Long parentId = null;

	private String name = null;

	private SimpleTreeNode parent = null;

	private List<SimpleTreeNode> children = new ArrayList<SimpleTreeNode>();

	@SuppressWarnings("unchecked")
	@Override
	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

//	@Override
//	public String getName() {
//		return name;
//	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public SimpleTreeNode getParent() {
//		return parent;
//	}

	@Override
	public void setParent(SimpleTreeNode parent) {
		this.parent = parent;
	}

	@Override
	public List<SimpleTreeNode> getChildren() {
		return children;
	}

}
