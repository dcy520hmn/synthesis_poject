package com.springboot.service.impl;

import com.springboot.mapper.TdPlanLegCopyMapper;
import com.springboot.mapper.TdPlanLegMapper;
import com.springboot.pojo.TdPlanLeg;
import com.springboot.service.TdPlanLegCopyService;
import com.springboot.util.DateUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TdPlanLegCopyService
 * @Description TODO 生成TdPleg数据,计算ring
 * @Author duanchunyu
 * @Date 2020/9/29 11:15
 * @VERSION 1.0
 **/
@Service
public class TdPlanLegCopyServiceImpl implements TdPlanLegCopyService {

    private static Logger logger = LoggerFactory.getLogger(TdPlanLegCopyServiceImpl.class);
    @Autowired
    private TdPlanLegCopyMapper tdPlanLegCopyMapper;

    @Autowired
    private TdPlanLegMapper tdPlanLegMapper;

    @Override
    public  List queryPlegLegByPage(Map map) {
        logger.info("============输入参数：========:::"+map);
        List<TdPlanLeg> tdPlanLegList = null;//0成功 ，1改日数据已处理
        Long id = MapUtils.getLong(map,"id");
        Long fltId = MapUtils.getLong(map,"fltId");
        String plegDate = MapUtils.getString(map,"plegDate");
        String arrThr = MapUtils.getString(map,"arrThr");
        String depThr = MapUtils.getString(map,"depThr");
        String regNo = MapUtils.getString(map,"regNo");
        Integer page = MapUtils.getInteger(map,"page");
        Integer count = MapUtils.getInteger(map,"count");
        Integer flag = MapUtils.getInteger(map,"flag");
        LocalDate currentDateTime = null;
        if(plegDate!=null){
            currentDateTime = LocalDate.parse(plegDate, DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYYMMDD));
        }
        logger.info("====================开始查询======================");
        long beginQueryTime = System.currentTimeMillis();
        tdPlanLegList = tdPlanLegCopyMapper.queryTdPlanLegCopyByPage(id,fltId,currentDateTime,arrThr,depThr,regNo,page,count);
        long endQueryTime = System.currentTimeMillis();
        logger.info("====================查询结束==================用时:::==="+(endQueryTime-beginQueryTime)/1000.0+"s");
        logger.info("====================开始插入======================");
        long beginInsert = System.currentTimeMillis();
        if(tdPlanLegList!=null&&tdPlanLegList.size()>0){
            if(flag == 1){
                tdPlanLegMapper.insertBatch(tdPlanLegList);
            }else if(flag == 0){
                for (TdPlanLeg tdPlanLeg : tdPlanLegList) {
                    tdPlanLegMapper.insert(tdPlanLeg);
                }
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("====================插入结束=================用时:::==="+(endInsert-beginInsert)/1000.0+"s");
        logger.info("====================总用时:::==="+(endInsert-beginQueryTime)/1000.0+"s");
        return tdPlanLegList;
    }

}
