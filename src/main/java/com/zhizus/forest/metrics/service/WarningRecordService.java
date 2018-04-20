package com.zhizus.forest.metrics.service;

import com.zhizus.forest.metrics.bean.WarningRecord;
import com.zhizus.forest.metrics.dao.WarningRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-20 上午11:47.
 */
@Service
public class WarningRecordService {
    @Autowired
    private WarningRecordDao warningRecordDao;

    public  List<WarningRecord>  findAll(){
        List<WarningRecord> warningRecords = warningRecordDao.selectAll();
        return warningRecords;
    }
}
