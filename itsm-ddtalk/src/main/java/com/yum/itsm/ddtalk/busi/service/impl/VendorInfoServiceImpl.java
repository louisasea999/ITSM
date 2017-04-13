package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroupExample;
import com.yum.itsm.ddtalk.busi.mapper.EmpleeInfoMapper;
import com.yum.itsm.ddtalk.busi.mapper.ServiceDeskMapper;
import com.yum.itsm.ddtalk.busi.mapper.SupProjectGroupMapper;
import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.Constants;
import com.yum.itsm.ddtalk.common.entity.Department;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;
import com.yum.itsm.ddtalk.common.service.DDTalkService;

@Service("vendorInfoService")
public class VendorInfoServiceImpl implements VendorInfoService {

    @Resource(name = "ddTalkService")
    private DDTalkService ddTalkService;
    
	// 服务商
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    SupProjectGroupMapper supProjectGroupMapper;
    
    // 服务站
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    ServiceDeskMapper serviceDeskMapper;
    
    // 工程师
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    EmpleeInfoMapper empleeInfoMapper;
    
	@Override
	public List<Department> getDepartmentList() {
		return ddTalkService.getDepartmentList();
	}

	@Override
	public void ddTalkDepartmentUpdater() {
		// TODO 算法需要改进
		List<SupProjectGroup> supsFromDD = procDDtalkDepartments();
		
		SupProjectGroupExample supExam = new SupProjectGroupExample();
		List<SupProjectGroup> supsFromDB = supProjectGroupMapper.selectByExample(supExam);
		
		
	}
	
	private List<SupProjectGroup> procDDtalkDepartments() {
		List<Department> departments = ddTalkService.getDepartmentList();
		Integer parentId = 0;
		Iterator<Department> it = departments.iterator();
		while(it.hasNext()) {
			Department dept = it.next();
			if (dept.getName().equals(Constants.SUP_NAME)) {
				parentId = dept.getParentid();
				it.remove();
				break;
			}
		}
		if (parentId == 0) {
			throw new ApplicationException("没有发现服务商部门");
		}

		List<SupProjectGroup> ret= new ArrayList<SupProjectGroup>();
		it = departments.iterator();
		while(it.hasNext()) {
			Department dept = it.next();
			if (dept.getParentid() == parentId) {
				SupProjectGroup sup = new SupProjectGroup();
				sup.setSupProjectGroupId(dept.getId());
				sup.setSupProjectGroupName(dept.getName());
				sup.setRemark(Constants.GSON.toJson(dept));
				ret.add(sup);
				it.remove();
			}
		}
		
//		for (SupProjectGroup sup : ret) {
//			it = departments.iterator();
//			
//			while(it.hasNext()) {
//				Department dept = it.next();
//				if (dept.getParentid() == sup.getSupProjectGroupId()) {
//					SupProjectGroup sup = new SupProjectGroup();
//					sup.setSupProjectGroupId(dept.getId());
//					sup.setSupProjectGroupName(dept.getName());
//					sup.setRemark(Constants.GSON.toJson(dept));
//					ret.add(sup);
//					it.remove();
//				}
//			}
//		}
		
		return ret;
	}
}
