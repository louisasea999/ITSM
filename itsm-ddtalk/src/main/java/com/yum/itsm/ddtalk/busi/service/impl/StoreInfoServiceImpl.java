package com.yum.itsm.ddtalk.busi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.itsm.ddtalk.busi.entity.DiningDeskMap;
import com.yum.itsm.ddtalk.busi.entity.DiningDeskMapExample;
import com.yum.itsm.ddtalk.busi.entity.DiningRoom;
import com.yum.itsm.ddtalk.busi.mapper.DiningDeskMapMapper;
import com.yum.itsm.ddtalk.busi.mapper.DiningRoomMapper;
import com.yum.itsm.ddtalk.busi.service.StoreInfoService;
import com.yum.itsm.ddtalk.common.exception.ApplicationException;

@Service("storeInfoServiceImpl")
public class StoreInfoServiceImpl implements StoreInfoService {

	// 区域
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
	private DiningRoomMapper diningRoomMapper;

    // 区域/服务商
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
	private DiningDeskMapMapper diningDeskMapMapper;
	
	@Override
	public List<DiningRoom> getDiningRoomList() {
		Map<String, Object> params = new HashMap<String, Object>();
		return diningRoomMapper.getDiningRoomDetails(params);
	}

	@Override
	public DiningRoom getDiningRoomInfo(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diningRoomId", id);
		List<DiningRoom> diningRooms = diningRoomMapper.getDiningRoomDetails(params);
		if (diningRooms.size() > 0) {
			return diningRooms.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void saveDiningDeskMap(Long id, List<DiningDeskMap> newMaps) {
		DiningDeskMapExample mapExam = new DiningDeskMapExample();
		mapExam.createCriteria().andDiningRoomIdEqualTo(id);
		List<DiningDeskMap> oldMaps = diningDeskMapMapper.selectByExample(mapExam);
		List<DiningDeskMap> updMaps = new ArrayList<DiningDeskMap>();
		
		Iterator<DiningDeskMap> itNewMap = newMaps.iterator();
		while(itNewMap.hasNext()) {
			DiningDeskMap newMap = itNewMap.next();
			if (newMap.getDiningRoomId().equals(id)) {
				Iterator<DiningDeskMap> itOldMap = oldMaps.iterator();
				while (itOldMap.hasNext()) {
					DiningDeskMap oldMap = itOldMap.next();
					if (oldMap.getServiceDeskId().equals(newMap.getServiceDeskId())) {
						newMap.setDiningDeskId(oldMap.getDiningDeskId());
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
		procDiningDeskMap(updMaps, oldMaps, newMaps);

	}

	@Override
	public void saveDiningDeskMap(List<DiningDeskMap> newMaps) {
		DiningDeskMapExample mapExam = new DiningDeskMapExample();
		List<DiningDeskMap> oldMaps = diningDeskMapMapper.selectByExample(mapExam);
		List<DiningDeskMap> updMaps = new ArrayList<DiningDeskMap>();
		
		Iterator<DiningDeskMap> itNewMap = newMaps.iterator();
		while(itNewMap.hasNext()) {
			DiningDeskMap newMap = itNewMap.next();
			Iterator<DiningDeskMap> itOldMap = oldMaps.iterator();
			while (itOldMap.hasNext()) {
				DiningDeskMap oldMap = itOldMap.next();
				if (oldMap.getDiningRoomId().equals(newMap.getDiningRoomId()) &&
						oldMap.getServiceDeskId().equals(newMap.getServiceDeskId())) {
					newMap.setDiningDeskId(oldMap.getDiningDeskId());
					updMaps.add(newMap);
					itNewMap.remove();
					itOldMap.remove();
					break;
				}
			}
		}
		procDiningDeskMap(updMaps, oldMaps, newMaps);
	}
	
	private void procDiningDeskMap(List<DiningDeskMap> updMaps, 
			List<DiningDeskMap> delMaps, List<DiningDeskMap> addMaps) {
		// 删除
		for (DiningDeskMap map : delMaps) {
			DiningDeskMapExample mapExam = new DiningDeskMapExample();
			mapExam.createCriteria().andDiningDeskIdEqualTo(map.getDiningDeskId());
			diningDeskMapMapper.deleteByExample(mapExam);
		}
		// 追加
		for (DiningDeskMap map : addMaps) {
			// TODO 随机添加zone数据
			map.setZoneLevel(calcZone());
			map.setDiningDeskId(diningDeskMapMapper.selectIdSeq());
			diningDeskMapMapper.insert(map);
		}
		// 更新
		for (DiningDeskMap map : updMaps) {
			// TODO 随机添加zone数据
			map.setZoneLevel(calcZone());
			diningDeskMapMapper.updateByPrimaryKey(map);
		}
	}
	
	private Integer calcZone() {
        int max=4;
        int min=1;
        Random random = new Random();

        return new Integer(random.nextInt(max)%(max-min+1) + min);
	}

	@Override
	public List<DiningDeskMap> getDiningDeskMap(Long id) {
		DiningDeskMapExample mapExam = new DiningDeskMapExample();
		if (id != null) {
			mapExam.createCriteria().andDiningRoomIdEqualTo(id);
		}
		return diningDeskMapMapper.selectByExample(mapExam);
	}
}
