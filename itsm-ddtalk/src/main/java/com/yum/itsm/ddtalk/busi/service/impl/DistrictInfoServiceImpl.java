package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMap;
import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMapExample;
import com.yum.itsm.ddtalk.busi.entity.DistrictInfo;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;
import com.yum.itsm.ddtalk.busi.mapper.DistrictGroupMapMapper;
import com.yum.itsm.ddtalk.busi.mapper.DistrictInfoMapper;
import com.yum.itsm.ddtalk.busi.service.DistrictInfoService;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;

@Service("districtInfoService")
public class DistrictInfoServiceImpl implements DistrictInfoService {

	// 区域
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DistrictInfoMapper districtInfoMapper;

    // 区域/服务商
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DistrictGroupMapMapper districtGroupMapMapper;
	
	@Override
	public List<DistrictInfo> getDistrictList() {
		Map<String, Object> params = new HashMap<String, Object>();
		return districtInfoMapper.getDistrictDetails(params);
	}

	@Override
	public DistrictInfo getDistrictInfo(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("districtId", id);
		List<DistrictInfo> districts = districtInfoMapper.getDistrictDetails(params);
		if (districts!= null && districts.size() > 0) {
			return districts.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void saveDistrictGroupMap(Long id, List<DistrictGroupMap> newMaps) {
		DistrictGroupMapExample mapExam = new DistrictGroupMapExample();
		mapExam.createCriteria().andDistrictIdEqualTo(id);
		List<DistrictGroupMap> oldMaps = districtGroupMapMapper.selectByExample(mapExam);
		List<DistrictGroupMap> updMaps = new ArrayList<DistrictGroupMap>();
		
		Iterator<DistrictGroupMap> itNewMap = newMaps.iterator();
		while(itNewMap.hasNext()) {
			DistrictGroupMap newMap = itNewMap.next();
			if (newMap.getDistrictId().equals(id)) {
				Iterator<DistrictGroupMap> itOldMap = oldMaps.iterator();
				while (itOldMap.hasNext()) {
					DistrictGroupMap oldMap = itOldMap.next();
					if (oldMap.getSupProjectGroupId().equals(newMap.getSupProjectGroupId())) {
						newMap.setDistrictGroupId(oldMap.getDistrictGroupId());
						updMaps.add(newMap);
						itNewMap.remove();
						itOldMap.remove();
						break;
					}
				}
			} else {
				throw new ApplicationException("进行了非本区域的数据");
			}
		}
		procDistrictGroupMap(updMaps, oldMaps, newMaps);
	}
	
	private void procDistrictGroupMap(List<DistrictGroupMap> updMaps, 
			List<DistrictGroupMap> delMaps, List<DistrictGroupMap> addMaps) {
		// 删除
		for (DistrictGroupMap map : delMaps) {
			DistrictGroupMapExample mapExam = new DistrictGroupMapExample();
			mapExam.createCriteria().andDistrictGroupIdEqualTo(map.getDistrictGroupId());
			districtGroupMapMapper.deleteByExample(mapExam);
		}
		// 追加
		for (DistrictGroupMap map : addMaps) {
			map.setDistrictGroupId(districtGroupMapMapper.selectIdSeq());
			districtGroupMapMapper.insert(map);
		}
		// 更新
		for (DistrictGroupMap map : updMaps) {
			districtGroupMapMapper.updateByPrimaryKey(map);
		}
	}

	@Override
	public void saveDistrictGroupMap(List<DistrictGroupMap> newMaps) {
		DistrictGroupMapExample mapExam = new DistrictGroupMapExample();
		List<DistrictGroupMap> oldMaps = districtGroupMapMapper.selectByExample(mapExam);
		List<DistrictGroupMap> updMaps = new ArrayList<DistrictGroupMap>();
		
		Iterator<DistrictGroupMap> itNewMap = newMaps.iterator();
		while(itNewMap.hasNext()) {
			DistrictGroupMap newMap = itNewMap.next();
			Iterator<DistrictGroupMap> itOldMap = oldMaps.iterator();
			while (itOldMap.hasNext()) {
				DistrictGroupMap oldMap = itOldMap.next();
				if (oldMap.getDistrictId().equals(newMap.getDistrictId()) &&
						oldMap.getSupProjectGroupId().equals(newMap.getSupProjectGroupId())) {
					newMap.setDistrictGroupId(oldMap.getDistrictGroupId());
					updMaps.add(newMap);
					itNewMap.remove();
					itOldMap.remove();
					break;
				}
			}
		}
		procDistrictGroupMap(updMaps, oldMaps, newMaps);
	}

	@Override
	public List<DistrictGroupMap> getDistrictGroupMap(Long id) {
		DistrictGroupMapExample mapExam = new DistrictGroupMapExample();
		if (id != null) {
			mapExam.createCriteria().andDistrictIdEqualTo(id);
		}
		return districtGroupMapMapper.selectByExample(mapExam);
	}
}
