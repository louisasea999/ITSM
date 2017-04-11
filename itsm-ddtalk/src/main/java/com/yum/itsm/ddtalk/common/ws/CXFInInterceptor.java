package com.yum.itsm.ddtalk.common.ws;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yum.itsm.ddtalk.common.Constants;

//import com.ciicsh.common.spring.SpringContextUtil;
//import com.ciicsh.system.service.UserInfoService;
//import com.ciicsh.system.service.SysParameterService;

public class CXFInInterceptor extends AbstractOutDatabindingInterceptor {

	/**
	 * Slf4j Logger 
	 **/
	private static Logger logger = LoggerFactory.getLogger(CXFInInterceptor.class);

	public CXFInInterceptor() {
		super(Phase.UNMARSHAL);
	}

	public void handleMessage(Message inMessage) {
		Map<String, List<String>> headers = (Map<String, List<String>>) inMessage.get(Message.PROTOCOL_HEADERS);
		if (headers == null) {
			headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
			inMessage.put(	Message.PROTOCOL_HEADERS,
											headers);
		}
		// modify headers
//		headers.put(	"Access-Control-Allow-Origin",
//										Arrays.asList("*"));
		
		List<String> uids = headers.get(Constants.LOGIN_USER_ID_HEADER);
		logger.info("Login User info : " + uids);
		if(CollectionUtils.isNotEmpty(uids)) {
//			String uid = uids.get(0);
			headers.put(	Constants.LOGIN_USER_ID,
			            	uids);
		} else {
			// TODO 模拟当前登录用户，实际环境不允许
			logger.error("登录信息为空，请先登录系统！");
//			SysParameterService parameterService = SpringContextUtil.getBean(SysParameterService.class);
//			String dev = parameterService.findParameterByName("process", "dev");
//			dev = StringUtils.defaultString(dev, "false");
//			if(dev.equalsIgnoreCase("true")) {
//				headers.put(	Constants.LOGIN_USER_ID,
//				            	Arrays.asList("zhouxiaoxiao"));
//			} else {
//				throw new RuntimeException("登录信息为空，请先登录系统！");
//			}
			headers.put(	Constants.LOGIN_USER_ID,
	            	Arrays.asList("zhouxiaoxiao"));
		}
		
//		// 获取当前用户信息
//		List<String> loginUserList = headers.get(Constants.LOGIN_USER_ID);
//		if(loginUserList == null || loginUserList.size() == 0) {
//			throw new RuntimeException("当前用户没有登录");
//		}
//		String loginUserId = loginUserList.get(0);
//		SpringContextUtil.getBean(UserInfoService.class).findUserInfoById(loginUserId);
	}
}