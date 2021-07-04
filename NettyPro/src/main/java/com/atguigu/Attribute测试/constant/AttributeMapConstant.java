package com.atguigu.Attribute测试.constant;

import com.atguigu.Attribute测试.server.NettyChannel;
import io.netty.util.AttributeKey;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/24 9:43
 * @Version 1.0
 **/
public class AttributeMapConstant {

    public static final AttributeKey<NettyChannel> NETTY_CHANNEL_KEY = AttributeKey.valueOf("netty.channel");
}
