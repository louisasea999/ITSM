package com.yum.itsm.ddtalk.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yum.itsm.ddtalk.common.Constants;
import com.yum.itsm.ddtalk.common.dto.AccessTokenMsgDTO;
import com.yum.itsm.ddtalk.common.dto.DepartmentListMsgDTO;
import com.yum.itsm.ddtalk.common.entity.Department;
import com.yum.itsm.ddtalk.common.service.DDTalkService;
import com.yum.itsm.ddtalk.common.service.HttpClientService;

@Service
public class DDTalkServiceImpl implements DDTalkService {
	private static final String GET_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";
	private static final String GET_DEPARTMENT_LIST_URL = "https://oapi.dingtalk.com/department/list";
	
	
	private String corpId;
	private String corpSecret;
	
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public String getCorpSecret() {
		return corpSecret;
	}
	public void setCorpSecret(String corpSecret) {
		this.corpSecret = corpSecret;
	}
	
    @Resource(name = "httpClientService")
    private HttpClientService httpClientService;

	@Override
	public String getToken() {
		Map<String, String> paras = new HashMap<>();
		paras.put("corpid", corpId);
		paras.put("corpsecret", corpSecret);
		String resString = httpClientService.getRemoteResponse(
				GET_TOKEN_URL, null, null, paras
			);
		
		AccessTokenMsgDTO accessToken = Constants.GSON.fromJson(resString, 
				AccessTokenMsgDTO.class);
		// TODO 出错处理
		return accessToken.getAccess_token();
	}
	
	@Override
	public List<Department> getDepartmentList() {

		Map<String, String> paras = new HashMap<>();
		paras.put("access_token", getToken());
		String resString = httpClientService.getRemoteResponse(
				GET_DEPARTMENT_LIST_URL, null, null, paras
			);
		DepartmentListMsgDTO departmentList = Constants.GSON.fromJson(resString, 
				DepartmentListMsgDTO.class);
		
		return departmentList.getDepartmentList();
	}
	
	
}
