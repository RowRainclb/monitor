package com.zhizus.forest.metrics.service;

import com.zhizus.forest.metrics.bean.MonitorServer;
import com.zhizus.forest.metrics.dao.MonitorServerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-20 上午11:47.
 */
@Service
public class MonitorServiceService {
    @Autowired
    private MonitorServerDao monitorServerDao;

    public  List<MonitorServer>  findAll(){
        List<MonitorServer> services = monitorServerDao.selectAll();
        return services;
    }
    public void add(MonitorServer monitorServer){
        monitorServerDao.insert(monitorServer);
    }

}
