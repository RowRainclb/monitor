package com.zhizus.forest.metrics.controller;

import com.alibaba.fastjson.JSON;
import com.zhizus.forest.metrics.JsonResult;
import com.zhizus.forest.metrics.bean.App;
import com.zhizus.forest.metrics.bean.User;
import com.zhizus.forest.metrics.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 监听服务
 *
 * @author clb
 * @date 2018年04月19日17:40:44
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping("/index.do")
    public String index() {
        return "forest/app";
    }

    @RequestMapping("/save.do")
    @ResponseBody
    public String save(@RequestParam String serviceName, HttpSession session, HttpServletRequest request) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return JsonResult.failedWithUnauthorized().toJSONString();
        }
        App app = new App();
        app.setServiceName(serviceName);
        app.setCreateBy(user.getName());
        String appKey = UUID.randomUUID().toString().replace("-", "");
        app.setAppKey(appKey);
        appService.save(app);
        return JsonResult.successResult().setData(app).toJSONString();
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String list() {
        return JSON.toJSONString(appService.find());
    }

}
