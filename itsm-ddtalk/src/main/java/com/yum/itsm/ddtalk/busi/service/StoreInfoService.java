package com.yum.itsm.ddtalk.busi.service;

import java.util.List;

import com.yum.itsm.ddtalk.busi.entity.DiningDeskMap;
import com.yum.itsm.ddtalk.busi.entity.DiningRoom;

public interface StoreInfoService {
	List<DiningRoom> getDiningRoomList();
	
	DiningRoom getDiningRoomInfo(Long id);
	
	void saveDiningDeskMap(Long id, List<DiningDeskMap> newMaps);

	void saveDiningDeskMap(List<DiningDeskMap> newMaps);
	
	List<DiningDeskMap> getDiningDeskMap(Long id);
}
