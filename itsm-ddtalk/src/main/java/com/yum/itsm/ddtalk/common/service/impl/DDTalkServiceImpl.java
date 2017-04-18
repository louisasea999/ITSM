package com.yum.itsm.ddtalk.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yum.itsm.ddtalk.common.Constants;
import com.yum.itsm.ddtalk.common.dto.AccessTokenDDTalkMsgDTO;
import com.yum.itsm.ddtalk.common.dto.DDTalkMsgDTO;
import com.yum.itsm.ddtalk.common.dto.DepartmentListDDTalkMsgDTO;
import com.yum.itsm.ddtalk.common.dto.UserListDDTalkMsgDTO;
import com.yum.itsm.ddtalk.common.entity.DDTalkDepartment;
import com.yum.itsm.ddtalk.common.entity.DDTalkUser;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;
import com.yum.itsm.ddtalk.common.service.DDTalkService;
import com.yum.itsm.ddtalk.common.service.HttpClientService;
import com.yum.itsm.ddtalk.common.utils.FileUtils;

@Service
public class DDTalkServiceImpl implements DDTalkService {
	private static final String GET_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";
	private static final String GET_DEPARTMENT_LIST_URL = "https://oapi.dingtalk.com/department/list";
	private static final String GET_USER_LIST_URL = "https://oapi.dingtalk.com/user/list";
	private static final String POST_ROBOT_SEND = "https://oapi.dingtalk.com/robot/send";
	
	private String corpId;
	private String corpSecret;
	
	public static Timer timer = null;
	// 调整到1小时50分钟
	public static final long cacheTime = 1000 * 60 * 55 * 2;
	public static long currentTime = 0 + cacheTime + 1;
	public static long lastTime = 0;
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
		long curTime = System.currentTimeMillis();
		JSONObject accessTokenValue = (JSONObject) FileUtils.getValue("accesstoken", this.corpId);
		String accToken = "";
		JSONObject jsontemp = new JSONObject();
		if (accessTokenValue == null || curTime - accessTokenValue.getLong("begin_time") >= this.cacheTime) {
			Map<String, String> paras = new HashMap<>();
			paras.put("corpid", this.corpId);
			paras.put("corpsecret", this.corpSecret);
			String resString = httpClientService.getRemoteResponse(
					GET_TOKEN_URL, null, null, paras
				);
	        Gson gson = new Gson();
	        AccessTokenDDTalkMsgDTO accessToken = gson.fromJson(resString, 
	        		new TypeToken<AccessTokenDDTalkMsgDTO>() {}.getType());
	        if (accessToken.getErrCode().equals(DDTalkMsgDTO.CODE_OK)) {
		        accToken = accessToken.getAccess_token();
	        } else {
	        	throw new ApplicationException(accessToken.getErrMsg());
	        }
	        
	        // save accessToken
			JSONObject jsonAccess = new JSONObject();
			jsontemp.clear();
			jsontemp.put("access_token", accToken);
			jsontemp.put("begin_time", curTime);
			jsonAccess.put(this.corpId, jsontemp);
			FileUtils.write2File(jsonAccess, "accesstoken");
		} else {
			return accessTokenValue.getString("access_token");
		}
		
		return accToken;
	}
	
	@Override
	public List<DDTalkDepartment> getDepartmentList() {

		Map<String, String> paras = new HashMap<>();
		paras.put("access_token", getToken());
		String resString = httpClientService.getRemoteResponse(
				GET_DEPARTMENT_LIST_URL, null, null, paras
			);

        Gson gson = new Gson();
        DepartmentListDDTalkMsgDTO departmentList = gson.fromJson(resString, 
        		new TypeToken<DepartmentListDDTalkMsgDTO>() {}.getType());
		if (!departmentList.getErrCode().equals(DDTalkMsgDTO.CODE_OK)) {
        	throw new ApplicationException(departmentList.getErrMsg());
		}

		return departmentList.getDepartment();
	}
	@Override
	public List<DDTalkUser> getUserList(Long departmentId) {
		Map<String, String> paras = new HashMap<>();
		paras.put("access_token", getToken());
		paras.put("department_id", String.valueOf(departmentId));
		String resString = httpClientService.getRemoteResponse(
				GET_USER_LIST_URL, null, null, paras
			);

        Gson gson = new Gson();
        UserListDDTalkMsgDTO userList = gson.fromJson(resString, 
        		new TypeToken<UserListDDTalkMsgDTO>() {}.getType());
		if (!userList.getErrCode().equals(DDTalkMsgDTO.CODE_OK)) {
        	throw new ApplicationException(userList.getErrMsg());
		}
		
		return userList.getUserlist();
	}
	@Override
	public void sendMsgByRobot(String robotToken, String msg) {
		Map<String, String> paras = new HashMap<>();
		paras.put("access_token", robotToken);
		String resString = httpClientService.postRemoteResponse(
				POST_ROBOT_SEND, null, null, paras, msg);
		
        Gson gson = new Gson();
        DDTalkMsgDTO ret = gson.fromJson(resString, 
        		new TypeToken<UserListDDTalkMsgDTO>() {}.getType());
		if (!ret.getErrCode().equals(DDTalkMsgDTO.CODE_OK)) {
        	throw new ApplicationException(ret.getErrMsg());
		}
	}
}
