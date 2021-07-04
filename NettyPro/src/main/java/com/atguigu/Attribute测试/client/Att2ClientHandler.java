package com.atguigu.Attribute测试.client;

import com.atguigu.Attribute测试.server.NettyChannel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;

import java.util.Date;

import static com.atguigu.Attribute测试.constant.AttributeMapConstant.NETTY_CHANNEL_KEY;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/24 9:39
 * @Version 1.0
 **/
public class Att2ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Attribute<NettyChannel> attr = ctx.attr(NETTY_CHANNEL_KEY);
        NettyChannel nChannel = attr.get();
        if (nChannel == null) {
            NettyChannel newNChannel = new NettyChannel("Att2Client", new Date());
            attr.setIfAbsent(newNChannel);
        }else {
            System.out.println("这是第二个处理器");
            System.out.println(nChannel.getName() + "=======channelRead attributeMap 中是有值的");
            System.out.println(nChannel.getName() + "=======" + nChannel.getCreateDate());
        }
        System.out.println("Att2CientHandler Active");
        ctx.fireChannelActive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Attribute<NettyChannel> attr = ctx.attr(NETTY_CHANNEL_KEY);
        NettyChannel nChannel = attr.get();
        if (nChannel == null) {
            NettyChannel newNChannel = new NettyChannel("Att2Client", new Date());
            attr.setIfAbsent(newNChannel);
        }else {
            System.out.println(nChannel.getName() + "=======channelRead attributeMap 中是有值的");
            System.out.println(nChannel.getName() + "=======" + nChannel.getCreateDate());
        }
        System.out.println("Att2ClientHandler read Message:" + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}