package com.yum.itsm.ddtalk.common.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yum.itsm.ddtalk.common.dto.BusinessMsgDTO;
import com.yum.itsm.ddtalk.common.mail.CiicMailSenderImpl;


@Path(value = "/sendmail")
@Produces("application/json")
public class MailRestService extends BaseRestService {

    /**
     * Slf4j Logger
     **/
    private static Logger logger = LoggerFactory.getLogger(MailRestService.class);

    @Context
    private UriInfo uriInfo;

    @Context
    private Request request;
    
    @Autowired  
    private CiicMailSenderImpl ciicMailSenderImpl;
	
//	@Autowired
//	UserInfoService userService;
	
    @GET
    @Path("/common")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
    public BusinessMsgDTO sendCommonMail() {
		logger.info("####sendCommonMail#####");
        String strMail = uriInfo.getQueryParameters().getFirst("mail");
		logger.info("Method : " + request.getMethod());
		logger.info("uri : " + uriInfo.getPath());
		
		BusinessMsgDTO msgBean = new BusinessMsgDTO();
//		try {
//            if (StringUtils.isBlank(strMail)) {
//                throw new RuntimeException("邮件发送参数不能为空");
//            }
//            Gson gson = new Gson();
//            MailDTO mail = gson.fromJson(strMail, new TypeToken<MailDTO>() {}.getType());
//			if (mail.getToAddress() == null) {
//				convertUserId(mail);
//			} else if (mail.getToAddress().size() == 0) {
//				convertUserId(mail);
//			}
//			
//			String msg = ciicMailSenderImpl.send2(mail.getToAddress(), mail.getSubject(), mail.getContext());
//			if (StringUtils.isNotBlank(msg)) {
//				msgBean.setMessage("以下邮件发送失败！" + "\r\n" + msg);
//			}
//		} catch (Exception e) {
//			logger.error("sendCommonMail", e);
//			msgBean.setStatus(MsgDTO.STATUS_FAIL);
//			msgBean.setMessage("邮件发送失败!");
//		}
    	
    	return msgBean;
    }
    
//    private void convertUserId(MailDTO mail) {
//		if (mail.getToUserId() != null) {
//			if (mail.getToUserId().size() != 0) {
//				List<String> toAddrs = new ArrayList<>();
//				for (String userId : mail.getToUserId()) {
//					toAddrs.add(userService.findUserInfoById(userId).getEmail());
//				}
//				mail.setToAddress(toAddrs);
//			} else {
//				throw new ApplicationException("收信人为空！");
//			}
//		} else {
//			throw new ApplicationException("收信人为空！");
//		}
//    }
}
