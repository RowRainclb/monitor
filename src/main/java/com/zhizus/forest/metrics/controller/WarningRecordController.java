package com.zhizus.forest.metrics.controller;

import com.alibaba.fastjson.JSONArray;
import com.zhizus.forest.metrics.service.WarningRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务的记录
 *
 * @author clb
 * @date 2018年04月19日17:41:44
 */
@Controller
@RequestMapping("/record")
public class WarningRecordController {
    @Autowired
    WarningRecordService warningRecordService;


    @ResponseBody
    @RequestMapping("/groupByUri.do")
    public String groupByUri(@RequestParam String serviceName) {
        return JSONArray.toJSONString(warningRecordService.findAll());
    }
}
