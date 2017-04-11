package com.yum.itsm.ddtalk.common.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.yum.itsm.ddtalk.common.exception.ApplicationException;

public class CiicMailSenderImpl extends JavaMailSenderImpl {
	
//	@Autowired
//	private OrgUserSyncService orgUserService;
	
	public void send2Higher(String userId, String subject, String context) 
			throws ApplicationException {
//		List<UserInfo> users;
//		List<String> toAddrs = new ArrayList<String>();
//		
//		try {
//			users = orgUserService.getDeptReportUser(userId);
//		} catch(Exception e) {
//			throw new ApplicationException("上级主管取得失败!");
//		}
//		
//		if (users.size() == 0) {
//			throw new ApplicationException("上级主管取得失败!");
//		} else {
//			for (UserInfo user : users) {
//				if (user.getEmail() != null && !user.getEmail().equals(""))
//					toAddrs.add(user.getEmail());
//			}
//		}
//		
//		if (users.size() == 0) {
//			throw new ApplicationException("上级主管取得失败!");
//		}
//
//		send2(toAddrs, "[系统信息]" + subject, context);
	}
	
	public String send2(List<String> toAddrs, String subject, String context) 
		throws ApplicationException {
		String ret = "";
//		try {
//			MimeMessage mimeMessage = super.createMimeMessage();
//	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//	        mimeMessageHelper.setFrom(getUsername());
//	        int size = toAddrs.size();
//	        String[] arr = (String[])toAddrs.toArray(new String[size]);
//	        mimeMessageHelper.setTo(arr);
//	        mimeMessageHelper.setSubject(subject);
//	        mimeMessageHelper.setText(context, true);
//			super.send(mimeMessage);
//		} catch (MailSendException msEx) {
//			Map<Object, Exception> exMap = msEx.getFailedMessages();
//			for (Exception ex : exMap.values()) {
//				if (ex instanceof SendFailedException) {
//					ret = getInvalidAddrs((SendFailedException)ex);
//					send2UnsentAddrs(toAddrs, subject, context, (SendFailedException)ex);
//				} else {
//					throw new ApplicationException("邮件发送失败!");
//				}
//			}
//		} catch (MailException mEx) {
//			throw new ApplicationException("邮件发送失败!");
//		} catch (MessagingException mEx) {
//			throw new ApplicationException("邮件发送失败!");
//		}
		return ret;
	}
	
	private void send2UnsentAddrs(List<String> toAddrs, String subject, String context, SendFailedException ex) {
		toAddrs.clear();
		for (Address addr : ex.getValidUnsentAddresses()) {
			toAddrs.add(addr.toString());
		}
		send2(toAddrs, subject, context);
	}
	
	private String getInvalidAddrs(SendFailedException ex) {
		String ret = "";
		for (Address addr : ex.getInvalidAddresses()) {
			ret += addr.toString() + ",";
		}
		if (StringUtils.isNotBlank(ret)) {
			ret = StringUtils.left(ret, ret.length() - 1);
		}
		return ret;
	}
}
