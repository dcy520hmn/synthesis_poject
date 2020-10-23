package com.springboot.controller;

import com.springboot.pojo.TdPlanLeg;
import com.springboot.service.TdPlanLegCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TdPlanLegTranController {

    @Autowired
    private TdPlanLegCopyService tdPlanLegCopyService;

    @RequestMapping("/tdPlanLegTran/dateByPage")
    public List queryPlanLegTranByPage(@RequestBody  Map map){
        List ret = null;
        ret = tdPlanLegCopyService.queryPlegLegByPage(map);
        return ret;
    }
}
