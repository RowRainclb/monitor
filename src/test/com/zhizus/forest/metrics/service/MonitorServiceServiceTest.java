package com.zhizus.forest.metrics.service;

import com.zhizus.forest.metrics.bean.MonitorServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-20 下午7:50.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml"})
public class MonitorServiceServiceTest {


    @Autowired
    MonitorServiceService monitorServiceService;

    @Test
    public void findAll () throws Exception {
        monitorServiceService.findAll();

    }

    @Test
    public void add () throws Exception {
        int a = monitorServiceService.findAll().size()+1;
        MonitorServer monitorServer = new MonitorServer();
        monitorServer.setStatus("fault");
        monitorServer.setCreateTime(new Date());
        monitorServer.setServerDesc("add a service");
        monitorServer.setName("监控外部接数");
        monitorServer.setZookeeperUrl("10.1.10.91:33");
        monitorServer.setTopic("default-data");
        monitorServiceService.add(monitorServer);
        int b = monitorServiceService.findAll().size();
        assertEquals(a,b);
    }

}