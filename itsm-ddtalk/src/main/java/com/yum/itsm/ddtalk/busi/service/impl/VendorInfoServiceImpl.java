package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yum.itsm.ddtalk.busi.entity.DeskRobotMap;
import com.yum.itsm.ddtalk.busi.entity.DeskRobotMapExample;
import com.yum.itsm.ddtalk.busi.entity.EmpleeInfo;
import com.yum.itsm.ddtalk.busi.entity.EmpleeInfoExample;
import com.yum.itsm.ddtalk.busi.entity.ServiceDesk;
import com.yum.itsm.ddtalk.busi.entity.ServiceDeskExample;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroupExample;
import com.yum.itsm.ddtalk.busi.entity.robot.LinkContent;
import com.yum.itsm.ddtalk.busi.entity.robot.LinkMsg;
import com.yum.itsm.ddtalk.busi.mapper.DeskRobotMapMapper;
import com.yum.itsm.ddtalk.busi.mapper.EmpleeInfoMapper;
import com.yum.itsm.ddtalk.busi.mapper.ServiceDeskMapper;
import com.yum.itsm.ddtalk.busi.mapper.SupProjectGroupMapper;
import com.yum.itsm.ddtalk.busi.service.VendorInfoService;
import com.yum.itsm.ddtalk.common.Constants;
import com.yum.itsm.ddtalk.common.entity.DDTalkDepartment;
import com.yum.itsm.ddtalk.common.entity.DDTalkUser;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;
import com.yum.itsm.ddtalk.common.service.DDTalkService;
import com.yum.itsm.ddtalk.common.utils.Utils;

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
    
    // 服务站机器人
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    DeskRobotMapMapper deskRobotMapMapper;
    
    // 工程师
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    EmpleeInfoMapper empleeInfoMapper;
    
	@Override
	public List<SupProjectGroup> getDeptsFromDDTalk() {
		return procDDtalkDepts(null);
	}

	@Override
	public SupProjectGroup getDeptFromDDTalk(Long id) {
		List<SupProjectGroup> depts = procDDtalkDepts(id);
		if (depts != null && depts.size() > 0) {
			return depts.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<SupProjectGroup> getDeptsFromDB() {
		Map<String, Object> params = new HashMap<String, Object>();
		return supProjectGroupMapper.getSupProjectGroupDetails(params);
	}
	
	@Override
	public SupProjectGroup getDeptFromDB(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("supProjectGroupId", id);
		List<SupProjectGroup> sups = supProjectGroupMapper.getSupProjectGroupDetails(params);
		if (sups != null && sups.size() > 0) {
			return sups.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateSupProjectGroupInfo() {
		List<SupProjectGroup> supsFromDD = procDDtalkDepts(null);
		this.procSupInfo(supsFromDD);
	}
	
	private void procSupInfo(List<SupProjectGroup> newSups) {
		// 服务商
		List<SupProjectGroup> delSups = new ArrayList<SupProjectGroup>();
		List<SupProjectGroup> updSups = new ArrayList<SupProjectGroup>();
		List<SupProjectGroup> addSups = new ArrayList<SupProjectGroup>();
		List<ServiceDesk> newDesks = new ArrayList<ServiceDesk>();
		SupProjectGroupExample supExam = new SupProjectGroupExample();
		List<SupProjectGroup> oldSups = supProjectGroupMapper.selectByExample(supExam);
		Iterator<SupProjectGroup> itNewSup = newSups.iterator();
		while(itNewSup.hasNext()) {
			SupProjectGroup newSup = itNewSup.next();
			newDesks.addAll(newSup.getServiceDesks());
			Iterator<SupProjectGroup> itOldSup = oldSups.iterator();
			while (itOldSup.hasNext()) {
				SupProjectGroup oldSup = itOldSup.next();
				if (oldSup.getSupProjectGroupId().equals(newSup.getSupProjectGroupId())) {
					updSups.add(newSup);
					itNewSup.remove();
					itOldSup.remove();
					break;
				}
			}
		}
		delSups.addAll(oldSups);
		addSups.addAll(newSups);
		
		// 服务站
		List<ServiceDesk> delDesks = new ArrayList<ServiceDesk>();
		List<ServiceDesk> updDesks = new ArrayList<ServiceDesk>();
		List<ServiceDesk> addDesks = new ArrayList<ServiceDesk>();
		List<EmpleeInfo> newEmps = new ArrayList<EmpleeInfo>();
		ServiceDeskExample deskExam = new ServiceDeskExample();
		List<ServiceDesk> oldDesks = serviceDeskMapper.selectByExample(deskExam);
		Iterator<ServiceDesk> itNewDesk = newDesks.iterator();
		while(itNewDesk.hasNext()) {
			ServiceDesk newDesk = itNewDesk.next();
			newEmps.addAll(newDesk.getEmpleeInfos());
			Iterator<ServiceDesk> itOldDesk = oldDesks.iterator();
			while (itOldDesk.hasNext()) {
				ServiceDesk oldDesk = itOldDesk.next();
				if (oldDesk.getServiceDeskId().equals(newDesk.getServiceDeskId())) {
					updDesks.add(newDesk);
					itNewDesk.remove();
					itOldDesk.remove();
					break;
				}
			}
		}
		delDesks.addAll(oldDesks);
		addDesks.addAll(newDesks);
		
		// 工作人员
		List<EmpleeInfo> delEmps = new ArrayList<EmpleeInfo>();
		List<EmpleeInfo> updEmps = new ArrayList<EmpleeInfo>();
		List<EmpleeInfo> addEmps = new ArrayList<EmpleeInfo>();
		EmpleeInfoExample empExam = new EmpleeInfoExample();
		List<EmpleeInfo> oldEmps = empleeInfoMapper.selectByExample(empExam);
		Iterator<EmpleeInfo> itNewEmp = newEmps.iterator();
		while(itNewEmp.hasNext()) {
			EmpleeInfo newEmp = itNewEmp.next();
			Iterator<EmpleeInfo> itOldEmp = oldEmps.iterator();
			while (itOldEmp.hasNext()) {
				EmpleeInfo oldEmp = itOldEmp.next();
				if (oldEmp.getEmpleeId().equals(newEmp.getEmpleeId())) {
					updEmps.add(newEmp);
					itNewEmp.remove();
					itOldEmp.remove();
					break;
				}
			}
		}
		delEmps.addAll(oldEmps);
		addEmps.addAll(newEmps);
		
		for (SupProjectGroup sup : delSups) {
			// 如果要使用ByPrimaryKey方法 请将参数改成id
			supExam = new SupProjectGroupExample();
			supExam.createCriteria().andSupProjectGroupIdEqualTo(sup.getSupProjectGroupId());
			supProjectGroupMapper.deleteByExample(supExam);
		}
		for (SupProjectGroup sup : addSups) {
			supProjectGroupMapper.insert(sup);
		}
		for (SupProjectGroup sup : updSups) {
			supProjectGroupMapper.updateByPrimaryKey(sup);
		}
		

		for (ServiceDesk desk : delDesks) {
			deskExam = new ServiceDeskExample();
			deskExam.createCriteria().andServiceDeskIdEqualTo(desk.getServiceDeskId());
			serviceDeskMapper.deleteByExample(deskExam);
		}
		for (ServiceDesk desk : addDesks) {
			serviceDeskMapper.insert(desk);
		}
		for (ServiceDesk desk : updDesks) {
			serviceDeskMapper.updateByPrimaryKey(desk);
		}
		
		for (EmpleeInfo emp : delEmps) {
			empExam = new EmpleeInfoExample();
			empExam.createCriteria().andEmpleeIdEqualTo(emp.getEmpleeId());
			empleeInfoMapper.deleteByExample(empExam);
		}
		for (EmpleeInfo emp : addEmps) {
			empleeInfoMapper.insert(emp);
		}
		for (EmpleeInfo emp : updEmps) {
			empleeInfoMapper.updateByPrimaryKey(emp);
		}
	}
	
	private List<SupProjectGroup> procDDtalkDepts(Long id) {
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
			if (id != null && !dept.getId().equals(id)) {
				continue;
			}
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

	@Override
	public void sendMsgByRobot(String issueKey, String deskName, String title, String text) {
		LinkMsg link = new LinkMsg();
		link.setLink(new LinkContent());
		link.getLink().setTitle(title);
		link.getLink().setText(text);
		link.getLink().setMessageUrl("http://itsmpoc6341.cloudapp.net:90/browse/" + issueKey);

		DeskRobotMapExample robotExam = new DeskRobotMapExample();
		robotExam.createCriteria().andServiceDeskNameEqualTo(deskName);
		List<DeskRobotMap> maps = deskRobotMapMapper.selectByExample(robotExam);
		
		if (Utils.listNotNull(maps)) {
			DeskRobotMap map = maps.get(0);
			Gson gson = new Gson();
			ddTalkService.sendMsgByRobot(map.getCustomRobotToken(), gson.toJson(link));
		} else {
			throw new ApplicationException("服务站:" + deskName + "不存在");
		}
	}
}
