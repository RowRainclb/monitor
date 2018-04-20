package com.zhizus.forest.metrics.dao;

import com.google.common.collect.Lists;
import com.zhizus.forest.metrics.bean.App;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDao {

    public List<App> find() {
        List<App> list = Lists.newArrayList();
        App app1 = new App();
        app1.setCreateBy("clb");
        app1.setAppKey("333");
        app1.setCreateAt(300L);
        app1.setServiceName("监听客户接入");
        app1.setTopic("defaultUser-defaultSpace-raw");
        app1.setZookeeperUrl("192.168.130.62:2181");
        app1.setStatus("正常");
        list.add(app1);
        App app2 = new App();
        app2.setCreateBy("clb");
        app2.setAppKey("333");
        app2.setCreateAt(300L);
        app2.setServiceName("监听异常数据");
        app2.setTopic("defaultUser-defaultSpace-exception");
        app2.setZookeeperUrl("192.168.130.62:2181");
        app1.setStatus("异常");
        list.add(app2);
        return list;
    }
}
