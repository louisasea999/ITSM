package com.yum.itsm.ddtalk.busi.ws;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.yum.itsm.ddtalk.common.ws.BaseRestService;

@Path(value = "/store")
@Produces({ "application/json; charset=UTF-8", "application/xml; charset=UTF-8" })
public class StoreInfoRestService extends BaseRestService{

}
