package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.entity.Department;
import com.yum.itsm.ddtalk.common.service.DDTalkService;

@Service
public class VendorInfoServiceImpl implements VendorInfoService {

    @Resource(name = "ddTalkService")
    private DDTalkService ddTalkService;
	
	@Override
	public List<Department> getDepartmentList() {
		return ddTalkService.getDepartmentList();
	}
	
}
