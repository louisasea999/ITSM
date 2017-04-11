package com.yum.itsm.ddtalk.common.tree;

import java.util.List;

public interface Node<T extends Node<?>> {

	public <S extends Object> S getNodeId();

	public <S extends Object> S getParentId();

//	public String getName();

//	public T getParent();

	public void setParent(T parent);

	public List<T> getChildren();

}