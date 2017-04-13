package com.yum.itsm.ddtalk.busi.controller;

import com.yum.itsm.ddtalk.busi.dto.MsgDTO;
import com.yum.itsm.ddtalk.busi.service.VendorInfoService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/vendor")
public class VendorInfoController {

    @Autowired
    private VendorInfoService vendorInfoService;

    @RequestMapping(value = "getDeptsFromDDTalk", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptsFromDDTalk() {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        msgDTO.setData(vendorInfoService.getDeptsFromDDTalk());
        return msgDTO;
    }

    @RequestMapping(value = "getDeptsFromDB", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptsFromDB() {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        msgDTO.setData(vendorInfoService.getDeptsFromDB());
        return msgDTO;
    }

    @RequestMapping(value = "ddTalkDeptUpdater", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO ddTalkDeptUpdater() {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        vendorInfoService.updateSupProjectGroupInfo();
        return msgDTO;
    }
    
}
