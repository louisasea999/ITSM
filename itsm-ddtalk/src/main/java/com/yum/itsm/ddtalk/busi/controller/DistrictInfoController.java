package com.yum.itsm.ddtalk.busi.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yum.itsm.ddtalk.busi.dto.MsgDTO;

@Controller
@RequestMapping("api/district")
public class DistrictInfoController {

    @RequestMapping(value = "list", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictList() {
        MsgDTO msgDTO = new MsgDTO();
        return msgDTO;
    }

    @RequestMapping(value = "info", method = {RequestMethod.GET})
    public @ResponseBody MsgDTO getDistrictInfo(@Param("id") Long id) {
        MsgDTO msgDTO = new MsgDTO();
        return msgDTO;
    }
}
