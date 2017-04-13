package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.DistrictInfo;
import com.yum.itsm.ddtalk.busi.entity.DistrictInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictInfoMapper {
    int countByExample(DistrictInfoExample example);

    int deleteByExample(DistrictInfoExample example);

    int deleteByPrimaryKey(Long districtId);

    int insert(DistrictInfo record);

    int insertSelective(DistrictInfo record);

    List<DistrictInfo> selectByExample(DistrictInfoExample example);

    DistrictInfo selectByPrimaryKey(Long districtId);

    int updateByExampleSelective(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);

    int updateByExample(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);

    int updateByPrimaryKeySelective(DistrictInfo record);

    int updateByPrimaryKey(DistrictInfo record);
}