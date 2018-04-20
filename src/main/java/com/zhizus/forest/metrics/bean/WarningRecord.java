package com.zhizus.forest.metrics.bean;

import java.util.Date;

/**
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-18 下午4:45.
 */
public class WarningRecord {

    private Long id;
    /**
     * 最后接收时间
     */
    private Date lastAcceptTime;
    /**
     * 告警时间
     */
    private Date warningTime;
    /**
     * 告警信息
     */
    private String message;
    /**
     * 告警信息状态
     * warning:告警中
     * normal: 已恢复
     */
    private String status;
    /**
     * 告警处理方式
     * 【发送邮件】
     */
    private String dealType;


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Date getLastAcceptTime () {
        return lastAcceptTime;
    }

    public void setLastAcceptTime (Date lastAcceptTime) {
        this.lastAcceptTime = lastAcceptTime;
    }

    public Date getWarningTime () {
        return warningTime;
    }

    public void setWarningTime (Date warningTime) {
        this.warningTime = warningTime;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getDealType () {
        return dealType;
    }

    public void setDealType (String dealType) {
        this.dealType = dealType;
    }
}
