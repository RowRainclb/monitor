package com.zhizus.forest.metrics.bean;

import java.util.Date;

/**
 * @Author cuilibo@k2data.com.cn
 * @Date 18-4-20 下午7:40.
 */
public class MonitorServer {

    private Long id;
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * zookeeperUrl
     */
    private String zookeeperUrl;
    /**
     * topic
     */
    private String topic;
    /**
     * 服务状态
     */
    private String status;
    /**
     * 服务状态
     */
    private String serverDesc;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getZookeeperUrl () {
        return zookeeperUrl;
    }

    public void setZookeeperUrl (String zookeeperUrl) {
        this.zookeeperUrl = zookeeperUrl;
    }

    public String getTopic () {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getServerDesc () {
        return serverDesc;
    }

    public void setServerDesc (String serverDesc) {
        this.serverDesc = serverDesc;
    }
}
