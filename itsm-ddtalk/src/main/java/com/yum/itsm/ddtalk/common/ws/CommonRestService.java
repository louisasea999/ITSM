package com.yum.itsm.ddtalk.common.ws;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yum.itsm.ddtalk.common.dto.BusinessMsgDTO;

@Path(value="/")
@Produces("application/json")
public class CommonRestService extends BaseRestService {
	
	/**
	 * Slf4j Logger 
	 **/
	private static Logger logger = LoggerFactory.getLogger(CommonRestService.class);
	
	@Context
	private UriInfo uriInfo;

	@Context 
	private HttpHeaders headers;

	@Context
	private Request request;
	
//	@Autowired
//	UserInfoService userService;

	@GET
	@Path("/date")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
	public BusinessMsgDTO getCurrentDate(@Context UriInfo uriInfo) {
		logger.info("#### getCurrentDate #####");
		logger.info("Method : " + request.getMethod());
		logger.info("uri : " + uriInfo.getPath());
		logger.info("uriInfo : " + uriInfo);
//		logger.info(uriInfo.getPathParameters());
		logger.info(uriInfo.getQueryParameters().toString());
		BusinessMsgDTO msgDTO = new BusinessMsgDTO();
		msgDTO.setData(new Date());
		return msgDTO;
	}

}
