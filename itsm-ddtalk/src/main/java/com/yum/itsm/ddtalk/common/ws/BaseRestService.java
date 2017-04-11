package com.yum.itsm.ddtalk.common.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseRestService {

	@Context
	private UriInfo uriInfo;

	@Context
	private HttpHeaders headers;

	@Context
	private Request request;
//
//	@Autowired
//	protected UserInfoService userService;
//
//	@Autowired
//	SysParameterService parameterService;

	public BaseRestService() {
		super();
	}

//	/**
//	 * getLoginUser: .<br/>
//	 * 
//	 * @return
//	 * 
//	 */
//	protected UserInfo getLoginedUser() {
//		// 获取当前用户信息
//		List<String> loginUserList = headers.getRequestHeader(Constants.LOGIN_USER_ID);
//		if (loginUserList == null || loginUserList.size() == 0) {
//			throw new RuntimeException("当前用户没有登录");
//		}
//		String loginUserId = loginUserList.get(0);
//		UserInfo user = userService.findUserInfoById(loginUserId);
//		
//		if(user == null)
//			user = new OrgUserSyncService().getUserFromRemote(loginUserId);
//		
//		if(user == null) {
//			throw new RuntimeException("登录用户未找到，请检查用户数据");
//		}
//		return user;
//	}
//
//	/**
//	 * getAttachmentRoot: 获取附件存放路径，并判断目录是否存在，不存在创建.<br/>
//	 * 
//	 * @return
//	 * @throws IOException
//	 * 
//	 */
//	protected File getAttachmentRoot(String relativePath)
//			throws IOException {
//		String defaultRoot = FileUtils.getFile(	"opt",
//																						"ciic",
//																						"sales",
//																						"attachment").toString();
//		String rootpath = parameterService.findParameterByName("system", 
//		                                                       "attachment.path");
//		rootpath = StringUtils.defaultString(	rootpath,
//																					defaultRoot);
//
//		String path = rootpath + StringUtils.defaultString(	relativePath,
//																												"");
//		// 判断目录是否存在，不存在创建
//		File root = new File(path);
//		FileUtils.forceMkdir(root);
//
//		return root;
//	}
//
//	/**
//	 * saveAttachment: 保存上传的附件到文件.<br/>
//	 * 
//	 * @param attachment
//	 * @param path
//	 * @param fileName
//	 * @return String File path relative to the attachment root directory
//	 * @throws IOException
//	 * 
//	 */
//	protected String saveAttachment(Attachment attachment,
//	                                File path,
//	                                String fileName)
//			throws IOException {
//		File root = getAttachmentRoot("");
//		InputStream in = attachment.getDataHandler().getInputStream();
//
//		// save file
//		String realname = fileName;
//		int l = fileName.lastIndexOf(".");
//		if (l < 0) {
//			realname = fileName + System.currentTimeMillis();
//		} else {
//			realname = fileName.substring(0,
//																		l) + "." + System.currentTimeMillis() + fileName.substring(l);
//		}
//		realname = new File(path, realname).toString(); 
//		File file = new File(	root,
//		                     	realname);
//		FileUtils.copyInputStreamToFile(in,
//																		file);
//		return realname;
//	}
//
//	/**
//	 * downloadAttachment: 下载附件.<br/>
//	 * 
//	 * @param attachments
//	 * @return
//	 * @throws IOException
//	 * 
//	 */
//	protected File downloadAttachment(List<com.ciicsh.system.entity.Attachment> attachments)
//			throws IOException {
//		File root = getAttachmentRoot("");
//		if (attachments.size() == 1) {
//			String fpath = attachments.get(0).getFileUrl();
//			File file = new File(root, fpath);
//			if (file.exists() && file.isFile()) {
//				return file;
//			} else {
//				return null;
//			}
//		} else {
//			File file = File.createTempFile("download",
//																			"tmp");
//			ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(file);
//
//			for (com.ciicsh.system.entity.Attachment attachment : attachments) {
//				String fname = attachment.getFileName();
//				String fpath = attachment.getFileUrl();
//				File tfile = new File(root,
//															fpath);
//				if (!tfile.exists() || !tfile.isFile()  ) {
//					zipOutputStream.close();
//					return null;
//				}
//				ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(tfile,
//																															fname);
//				zipOutputStream.putArchiveEntry(zipArchiveEntry);
//				FileInputStream fin = new FileInputStream(tfile);
//				IOUtils.copy(new FileInputStream(tfile), zipOutputStream);
//				
//				fin.close();
//				zipOutputStream.closeArchiveEntry();
//			}
//			
//			zipOutputStream.flush();
//			zipOutputStream.close();
//
//			return file;
//		}
//	}
}