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

    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictList() {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        msgDTO.setData(districtInfoService.getDistrictList());
        return msgDTO;
    }

    @RequestMapping(value = "info", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictInfo(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        msgDTO.setData(districtInfoService.getDistrictInfo(id));
        return msgDTO;
    }
    
    @RequestMapping(value = "save_map_by_id", method = {RequestMethod.POST})
    public @ResponseBody MsgDTO saveDistrictGroupMapById(@Param("id") Long id, @RequestBody List<DistrictGroupMap> maps) {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        districtInfoService.saveDistrictGroupMap(id, maps);
        return msgDTO;
    }
    
    @RequestMapping(value = "save_map", method = {RequestMethod.POST})
    public @ResponseBody MsgDTO saveDistrictGroupMap(@RequestBody List<DistrictGroupMap> maps) {
        MsgDTO msgDTO = new MsgDTO();
        msgDTO.setStatus(MsgDTO.STATUS_OK);
        districtInfoService.saveDistrictGroupMap(maps);
        return msgDTO;
    }
}
