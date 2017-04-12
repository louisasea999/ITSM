package com.yum.itsm.ddtalk.busi.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.dto.BusinessMsgDTO;
import com.yum.itsm.ddtalk.common.ws.BaseRestService;

@Path(value = "/vendor")
@Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
public class VendorInfoRestService extends BaseRestService {

    @Autowired
    private VendorInfoService vendorInfoService;
    
    @GET
    @Path("/getDepartmentList")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
    public BusinessMsgDTO getRuleRepositoryList() {
    	BusinessMsgDTO msgBean = new BusinessMsgDTO();
    	msgBean.setData(vendorInfoService.getDepartmentList());
    	return msgBean;
    }
}
