package com.zhizus.forest.metrics.dao;

import com.zhizus.forest.metrics.service.WarningRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-20 上午10:42.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml"})
public class WarningRecordDaoTest {

    @Autowired
    WarningRecordService warningRecordService;

    @Test
    public void selectAll () throws Exception {
        warningRecordService.findAll();
    }


}