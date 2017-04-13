package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.EmpleeInfo;
import com.yum.itsm.ddtalk.busi.entity.EmpleeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpleeInfoMapper {
    int countByExample(EmpleeInfoExample example);

    int deleteByExample(EmpleeInfoExample example);

    int insert(EmpleeInfo record);

    int insertSelective(EmpleeInfo record);

    List<EmpleeInfo> selectByExample(EmpleeInfoExample example);

    int updateByExampleSelective(@Param("record") EmpleeInfo record, @Param("example") EmpleeInfoExample example);

    int updateByExample(@Param("record") EmpleeInfo record, @Param("example") EmpleeInfoExample example);
}