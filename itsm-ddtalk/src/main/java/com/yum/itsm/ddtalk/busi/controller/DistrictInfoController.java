package com.yum.itsm.ddtalk.busi.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yum.itsm.ddtalk.busi.dto.MsgDTO;
import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMap;
import com.yum.itsm.ddtalk.busi.service.DistrictInfoService;

@Controller
@RequestMapping("api/district")
public class DistrictInfoController {
	
	@Autowired
	private DistrictInfoService districtInfoService;

	/**
	 * 从ITSM数据库取全部区域数据(包含服务商，服务站，门店)
	 * @return
	 */
    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictList() {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(districtInfoService.getDistrictList());
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }

    /**
     * 从ITSM数据库取指定区域数据(包含服务商，服务站，门店)
     * @param id
     * @return
     */
    @RequestMapping(value = "info", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictInfo(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(districtInfoService.getDistrictInfo(id));
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }
    
    /**
     * 更新全部或指定区域与服务商的关系
     * @param id
     * @param maps
     * @return
     */
    @RequestMapping(value = "save_map", method = {RequestMethod.POST})
    public @ResponseBody MsgDTO saveDistrictGroupMapById(@Param("id") Long id, @RequestBody List<DistrictGroupMap> maps) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        if (id != null) {
	            districtInfoService.saveDistrictGroupMap(id, maps);
	        } else {
	            districtInfoService.saveDistrictGroupMap(maps);
	        }
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }

    /**
     * 从ITSM数据库取全部或指定区域与服务商的关系
     * @param id
     * @return
     */
    @RequestMapping(value = "vendor_map", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictGroupMap(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(districtInfoService.getDistrictGroupMap(id));
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }
}
