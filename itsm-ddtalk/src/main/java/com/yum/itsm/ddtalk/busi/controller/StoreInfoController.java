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
import com.yum.itsm.ddtalk.busi.entity.DiningDeskMap;
import com.yum.itsm.ddtalk.busi.service.StoreInfoService;

@Controller
@RequestMapping("api/store")
public class StoreInfoController {
	
	@Autowired
	private StoreInfoService storeInfoService;

	/**
	 * 从ITSM数据库取全部门店数据(包含服务站)
	 * @return
	 */
    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDiningRoomList() {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(storeInfoService.getDiningRoomList());
        } catch (Exception e) {
        	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
        	msgDTO.setMessage(e.getMessage());
        }
        return msgDTO;
    }

    /**
     * 从ITSM数据库取指定门店的门店(包含服务站)
     * @param id
     * @return
     */
    @RequestMapping(value = "info", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDiningRoomInfo(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(storeInfoService.getDiningRoomInfo(id));
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }
    
    /**
     * 更新全部或指定门店与服务站的关系
     * @param id
     * @param maps
     * @return
     */
    @RequestMapping(value = "save_map", method = {RequestMethod.POST})
    public @ResponseBody MsgDTO saveDiningDeskMapById(@Param("id") Long id, 
    		@RequestBody List<DiningDeskMap> maps) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        if (id != null) {
	        	storeInfoService.saveDiningDeskMap(id, maps);
	        } else {
	        	storeInfoService.saveDiningDeskMap(maps);
	        }
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }

    /**
     * 取得全部或指定门店与服务站的关系
     * @param id
     * @return
     */
    @RequestMapping(value = "desk_map", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDiningDeskMap(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        try {
	        msgDTO.setStatus(MsgDTO.STATUS_OK);
	        msgDTO.setData(storeInfoService.getDiningDeskMap(id));
	    } catch (Exception e) {
	    	msgDTO.setStatus(MsgDTO.STATUS_FAIL);
	    	msgDTO.setMessage(e.getMessage());
	    }
        return msgDTO;
    }

}
