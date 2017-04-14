package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMap;
import com.yum.itsm.ddtalk.busi.entity.DistrictGroupMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictGroupMapMapper {
    int countByExample(DistrictGroupMapExample example);

    int deleteByExample(DistrictGroupMapExample example);

    int deleteByPrimaryKey(Long districtGroupId);

    int insert(DistrictGroupMap record);

    int insertSelective(DistrictGroupMap record);

    List<DistrictGroupMap> selectByExample(DistrictGroupMapExample example);

    DistrictGroupMap selectByPrimaryKey(Long districtGroupId);

    int updateByExampleSelective(@Param("record") DistrictGroupMap record, @Param("example") DistrictGroupMapExample example);

    int updateByExample(@Param("record") DistrictGroupMap record, @Param("example") DistrictGroupMapExample example);

    int updateByPrimaryKeySelective(DistrictGroupMap record);

    int updateByPrimaryKey(DistrictGroupMap record);

    long selectIdSeq();
}