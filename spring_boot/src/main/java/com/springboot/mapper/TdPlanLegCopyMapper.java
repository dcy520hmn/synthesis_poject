package com.springboot.mapper;

import com.springboot.pojo.TdPlanLeg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TdPlanLegCopyMapper {
    List<TdPlanLeg> queryTdPlanLegCopyByPage(@Param("id") Long id,
                                             @Param("fltId") Long fltId,
                                             @Param("plegDate") LocalDate plegDate,
                                             @Param("arrThr")String thr,
                                             @Param("depThr")String depThr,
                                             @Param("regNo")String regNo,
                                             @Param("page")Integer page,
                                             @Param("count")Integer count);
}
