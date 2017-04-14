package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.DiningDeskMap;
import com.yum.itsm.ddtalk.busi.entity.DiningDeskMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiningDeskMapMapper {
    int countByExample(DiningDeskMapExample example);

    int deleteByExample(DiningDeskMapExample example);

    int deleteByPrimaryKey(Long diningDeskId);

    int insert(DiningDeskMap record);

    int insertSelective(DiningDeskMap record);

    List<DiningDeskMap> selectByExample(DiningDeskMapExample example);

    DiningDeskMap selectByPrimaryKey(Long diningDeskId);

    int updateByExampleSelective(@Param("record") DiningDeskMap record, @Param("example") DiningDeskMapExample example);

    int updateByExample(@Param("record") DiningDeskMap record, @Param("example") DiningDeskMapExample example);

    int updateByPrimaryKeySelective(DiningDeskMap record);

    int updateByPrimaryKey(DiningDeskMap record);
}