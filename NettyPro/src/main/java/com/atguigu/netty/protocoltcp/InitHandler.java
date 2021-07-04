package com.atguigu.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/12/13 11:43
 * @Version 1.0
 **/
public class InitHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("服务器端的channelActive被激活了");
    }
}
