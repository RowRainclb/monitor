package com.zhizus.forest.metrics.dao;


import com.zhizus.forest.metrics.bean.MonitorServer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorServerDao {
    int deleteByPrimaryKey (Long id);

    int insert (MonitorServer record);

    int insertSelective (MonitorServer record);

    MonitorServer selectByPrimaryKey (Long id);

    List<MonitorServer> selectAll ();

    int updateByPrimaryKeySelective (MonitorServer record);

    int updateByPrimaryKey (MonitorServer record);
}