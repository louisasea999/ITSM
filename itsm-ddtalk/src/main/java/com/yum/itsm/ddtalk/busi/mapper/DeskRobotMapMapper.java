package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.DeskRobotMap;
import com.yum.itsm.ddtalk.busi.entity.DeskRobotMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeskRobotMapMapper {
    int countByExample(DeskRobotMapExample example);

    int deleteByExample(DeskRobotMapExample example);

    int deleteByPrimaryKey(Integer deskRobotId);

    int insert(DeskRobotMap record);

    int insertSelective(DeskRobotMap record);

    List<DeskRobotMap> selectByExample(DeskRobotMapExample example);

    DeskRobotMap selectByPrimaryKey(Integer deskRobotId);

    int updateByExampleSelective(@Param("record") DeskRobotMap record, @Param("example") DeskRobotMapExample example);

    int updateByExample(@Param("record") DeskRobotMap record, @Param("example") DeskRobotMapExample example);

    int updateByPrimaryKeySelective(DeskRobotMap record);

    int updateByPrimaryKey(DeskRobotMap record);
}