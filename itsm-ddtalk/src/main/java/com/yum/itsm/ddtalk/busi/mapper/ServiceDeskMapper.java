package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.ServiceDesk;
import com.yum.itsm.ddtalk.busi.entity.ServiceDeskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceDeskMapper {
    int countByExample(ServiceDeskExample example);

    int deleteByExample(ServiceDeskExample example);

    int insert(ServiceDesk record);

    int insertSelective(ServiceDesk record);

    List<ServiceDesk> selectByExample(ServiceDeskExample example);

    int updateByExampleSelective(@Param("record") ServiceDesk record, @Param("example") ServiceDeskExample example);

    int updateByExample(@Param("record") ServiceDesk record, @Param("example") ServiceDeskExample example);
}