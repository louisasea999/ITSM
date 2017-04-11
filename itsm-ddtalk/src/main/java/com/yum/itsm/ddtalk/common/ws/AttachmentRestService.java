package com.yum.itsm.ddtalk.common.ws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import com.ciicsh.system.service.AttachmentService;
//import com.ciicsh.system.service.UserInfoService;

@Path(value = "/files")
@Produces("application/json")
public class AttachmentRestService extends BaseRestService {
	private static Logger logger = LoggerFactory.getLogger(AttachmentRestService.class);

	@Context
	private UriInfo uriInfo;

	@Context
	private HttpHeaders headers;

	@Context
	private Request request;

//	@Autowired
//	UserInfoService userService;
//
//	@Autowired
//	AttachmentService attachmentService;

	public AttachmentRestService() {
		super();
	}

//	@POST
//	@Path("/upload")
//	// @Consumes("multipart/form-data")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
//	public List<com.ciicsh.system.entity.Attachment> upload(MultipartBody body) {
//		logger.info("------------ upload --------------");
//
//		List<com.ciicsh.system.entity.Attachment> list = new ArrayList<>();
//		try {
//			// 准备附件存放根目录路径
//			File relativePath = new File(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
//
//			List<Attachment> attachments = body.getAllAttachments();
//			for (Attachment attachment : attachments) {
//				ContentDisposition con = attachment.getContentDisposition();
//				logger.debug("upload: " + con.getParameters());
//
//				String fileName = con.getParameter("filename");
//				fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
//				String filePath = saveAttachment(	attachment,
//				                                 	relativePath,
//				                                 	fileName);
//
//				com.ciicsh.system.entity.Attachment attr = new com.ciicsh.system.entity.Attachment();
//				attr.setFileName(fileName);
//				attr.setFileUrl(filePath);
//
//				attachmentService.saveAttachemnt(attr);
//
//				list.add(attr);
//			}
//		} catch (Exception e) {
//			logger.error(	"upload",
//										e);
//			throw new RuntimeException("附件上传失败：" + e.getMessage());
//		}
//
//		return list;
//	}
//
//	@GET
//	@Path("download")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response downloadFile() {
//		String filename = uriInfo.getQueryParameters().getFirst("filename");
//		String filepath = uriInfo.getQueryParameters().getFirst("filepath");
//		
//		if(StringUtils.isBlank(filepath)) {
//			throw new NullPointerException("参数[filepath]不存在");
//		}
//		
//		if(StringUtils.isBlank(filename)) {
//			filename = new File(filepath).getName();
//		}
//		
//		List<com.ciicsh.system.entity.Attachment> attachments = new ArrayList<>();
//		com.ciicsh.system.entity.Attachment attachment = new com.ciicsh.system.entity.Attachment();
//		attachment.setFileName(filename);
//		attachment.setFileUrl(filepath);
//		attachments.add(attachment);
//		
//		return downloadFile(attachments);
//	}
//
//	@GET
//	@Path("download/{attachId}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response downloadFile(@PathParam("attachId") Integer attachId) {
//		com.ciicsh.system.entity.Attachment attachment = attachmentService.findAttachemntById(attachId);
//		
//		List<com.ciicsh.system.entity.Attachment> attachments = new ArrayList<>();
//		attachments.add(attachment);
//		
//		return downloadFile(attachments);
//	}
//
//	@POST
//	@Path("download")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response downloadFile(List<com.ciicsh.system.entity.Attachment> attachments) {
////		String filename = uriInfo.getQueryParameters().getFirst("filename");
////		List<String> fileList = uriInfo.getQueryParameters().get("filename");
//		
//		if(CollectionUtils.isEmpty(attachments)) {
//			throw new NullPointerException("附件列表参数不存在");
//		}
//		
//		try {
//			File file = downloadAttachment(attachments);
//			String fileName = null;
//			if(attachments.size() == 1) {
//				fileName = attachments.get(0).getFileName();
//			} else {
//				fileName = "download.zip";
//			}
//			
//			String mt = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName);
//			// 得到下载文件的名字
//			fileName = java.net.URLDecoder.decode(fileName,
//			                                      "utf-8");
//			if (file != null) {
//				return Response.ok(	file,
//														mt).header(	"Content-disposition",
//																				"attachment;filename=" + fileName).header("ragma",
//																																									"No-cache").header(	"Cache-Control",
//																																																			"no-cache").build();
//
//			} else {
//				return Response.status(Response.Status.NOT_FOUND).entity("下载失败，未找到该文件").build();
//			}
//		} catch (FileNotFoundException e) {
//			throw new NullPointerException(e.getMessage());
//		} catch (IOException e) {
//			throw new NullPointerException(e.getMessage());
//		}
//	}
}