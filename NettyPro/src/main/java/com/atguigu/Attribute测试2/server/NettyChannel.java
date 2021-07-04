package com.atguigu.Attribute测试2.server;

import java.util.Date;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/24 9:36
 * @Version 1.0
 **/
public class NettyChannel {
    private String name;


    private Date createDate;


    public NettyChannel(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}