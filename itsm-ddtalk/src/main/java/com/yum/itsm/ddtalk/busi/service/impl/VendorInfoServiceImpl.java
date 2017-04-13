package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.itsm.ddtalk.busi.entity.EmpleeInfo;
import com.yum.itsm.ddtalk.busi.entity.ServiceDesk;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroupExample;
import com.yum.itsm.ddtalk.busi.mapper.EmpleeInfoMapper;
import com.yum.itsm.ddtalk.busi.mapper.ServiceDeskMapper;
import com.yum.itsm.ddtalk.busi.mapper.SupProjectGroupMapper;
import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.Constants;
import com.yum.itsm.ddtalk.common.entity.DDTalkDepartment;
import com.yum.itsm.ddtalk.common.entity.DDTalkUser;
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
	public List<SupProjectGroup> getDeptsFromDDTalk() {
		return procDDtalkDepts();
	}

	@Override
	public void ddTalkDeptUpdater() {
		List<SupProjectGroup> supsFromDD = procDDtalkDepts();
		
		SupProjectGroupExample supExam = new SupProjectGroupExample();
		List<SupProjectGroup> supsFromDB = supProjectGroupMapper.selectByExample(supExam);
		
		
	}
	
	private List<SupProjectGroup> procDDtalkDepts() {
		List<DDTalkDepartment> departments = ddTalkService.getDepartmentList();
		Long parentId = 0L;
		Iterator<DDTalkDepartment> it = departments.iterator();
		while(it.hasNext()) {
			DDTalkDepartment dept = it.next();
			if (dept.getName().equals(Constants.SUP_NAME)) {
				parentId = dept.getId();
				it.remove();
				break;
			}
		}
		if (parentId.equals(0L)) {
			throw new ApplicationException("没有发现服务商部门");
		}

		// 服务商
		List<SupProjectGroup> ret= new ArrayList<SupProjectGroup>();
		it = departments.iterator();
		while(it.hasNext()) {
			DDTalkDepartment dept = it.next();
			if (dept.getParentid() != null && dept.getParentid().equals(parentId)) {
				SupProjectGroup sup = new SupProjectGroup();
				sup.setSupProjectGroupId(dept.getId());
				sup.setSupProjectGroupName(dept.getName());
				sup.setRemark(Constants.GSON.toJson(dept));
				ret.add(sup);
				it.remove();
			}
		}
		
		// 服务站
		for (SupProjectGroup sup : ret) {
			sup.setServiceDesks(new ArrayList<ServiceDesk>());
			it = departments.iterator();
			while(it.hasNext()) {
				DDTalkDepartment dept = it.next();
				if (dept.getParentid() != null && dept.getParentid().equals(sup.getSupProjectGroupId())) {
					ServiceDesk desk = new ServiceDesk();
					desk.setServiceDeskId(dept.getId());
					desk.setServiceDeskName(dept.getName());
					desk.setSupProjectGroupId(sup.getSupProjectGroupId());
					desk.setRemark(Constants.GSON.toJson(dept));
					
					// 工作人员
					desk.setEmpleeInfos(new ArrayList<EmpleeInfo>());
					List<DDTalkUser> userList = ddTalkService.getUserList(dept.getId());
					for (DDTalkUser user : userList) {
						EmpleeInfo emp = new EmpleeInfo();
						emp.setEmpleeId(user.getUserid());
						emp.setEmpleeName(user.getName());
						emp.setServiceDeskId(desk.getServiceDeskId());
						emp.setRemark(Constants.GSON.toJson(user));
						desk.getEmpleeInfos().add(emp);
					}
					
					sup.getServiceDesks().add(desk);
					it.remove();
				}
			}
		}
		
		return ret;
	}
}
