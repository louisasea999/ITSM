package com.yum.itsm.ddtalk.busi.controller;

import com.yum.itsm.ddtalk.busi.dto.MsgDTO;
import com.yum.itsm.ddtalk.busi.entity.DiningDeskMap;
import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin(maxAge = 3600)
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
    
    /**
     * 使用机器人向钉钉发送link信息
     */
    @RequestMapping(value = "robot/send", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO send(
    			@Param("issuekey") String issuekey,
    			@Param("deskname") String deskname, 
    			@Param("title") String title,
    			@Param("text") String text) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        if (issuekey != null && deskname != null) {
	        	if (title == null) {
	        		title = "案件有更新";
	        	}
	        	if (text == null) {
	        		text = "请点击链接";
	        	}
	        	vendorInfoService.sendMsgByRobot(issuekey, deskname, title, text);
	        } else if (issuekey == null) {
	        	throw new ApplicationException("issuekey is null");
	        } else if (deskname == null) {
	        	throw new ApplicationException("deskname is null");
	        }
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }
}
