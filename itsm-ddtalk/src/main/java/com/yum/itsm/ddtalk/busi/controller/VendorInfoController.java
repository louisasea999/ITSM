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

    /**
     * 从钉钉取全部服务商组织结构数据(包含服务站和工程师)
     * @return
     */
    @RequestMapping(value = "depts_ddtalk", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptsFromDDTalk() {
        MsgDTO msgDTO = new MsgDTO();
        try {
            msgDTO.setStatus(MsgDTO.STATUS_OK);
            msgDTO.setData(vendorInfoService.getDeptsFromDDTalk());
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }
    
    /**
     * 从ITSM数据库取全部服务商组织结构数据(包含服务站和工程师)
     * @return
     */
    @RequestMapping(value = "depts_db", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptsFromDB() {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(vendorInfoService.getDeptsFromDB());
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }

    /**
     * 从钉钉上把全部服务商组织结构数据(包含服务站和工程师)更新到ITSM数据库
     * 批处理
     * @return
     */
    @RequestMapping(value = "depts_ddtalk_update", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO ddTalkDeptUpdater() {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        vendorInfoService.updateSupProjectGroupInfo();
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }
    
    /**
     * 从钉钉取指定服务商的组织结构数据(包含服务站和工程师)
     * @return
     */
    @RequestMapping(value = "dept_ddtalk", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptFromDDTalk(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(vendorInfoService.getDeptFromDDTalk(id));
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }
    
    /**
     * 从ITSM数据库取指定服务商的组织结构数据(包含服务站和工程师)
     * @param id
     * @return
     */
    @RequestMapping(value = "dept_db", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDeptFromDB(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(vendorInfoService.getDeptFromDB(id));
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }
}
