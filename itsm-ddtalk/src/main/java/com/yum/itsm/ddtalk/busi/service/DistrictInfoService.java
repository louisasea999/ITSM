package com.yum.itsm.ddtalk.busi.service;

import java.util.List;

import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMap;
import com.yum.itsm.ddtalk.busi.entity.DistrictInfo;

public interface DistrictInfoService {
	List<DistrictInfo> getDistrictList();
	
	List<DistrictInfo> getDistrictInfo(Long id);
	
	void saveDistrictGroupMap(Long id, List<DistrictGroupMap> maps);

	void saveDistrictGroupMap(List<DistrictGroupMap> newMaps);
}
