package com.springboot.mapper;

import com.springboot.pojo.TdPlanLeg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TdPlanLegMapper {

    int insertBatch(@Param("legList") List<TdPlanLeg> legList);

    int insert(TdPlanLeg record);

}