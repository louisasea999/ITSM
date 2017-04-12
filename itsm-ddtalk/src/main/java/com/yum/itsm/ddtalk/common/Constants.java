package com.yum.itsm.ddtalk.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {
	
	public final static String LOGIN_USER = "LOGIN_USER";
	
	public final static String LOGIN_USER_ID = "LOGIN_USERID"; //   LOGIN_USERID
	
	public final static String LOGIN_USER_ID_HEADER = "G1-Subject"; //  LOGIN_USERID
	
//	public final static String MYBATIS_PAGINATION_PARAM_NAME = "_pagination_";
//	
//	public final static String MYBATIS_PAGINATION_FIELD_NAME = "page";
	
	// 安全上下文
	public final static String SECURITY_CONTEXT = "SECURITY_CONTEXT";
	
	// 分页相关参数定义
	public final static String PAGINATION_PARAM_PAGENUM  = "page";
	public final static String PAGINATION_PARAM_PAGESIZE  = "pageSize";
	public final static String PAGINATION_PARAM_OFFSET  = "offset";
	public final static String PAGINATION_PARAM_SORT  = "sortClause";
	
    private static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.create();
}
