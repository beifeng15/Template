package com.atguigu.netty.异步测试;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/13 10:03
 * @Version 1.0
 **/

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    private static Logger log = Logger.getLogger(NettyServerHandler.class);
    /**
     * 通道准备就绪时触发
     * @param ctx
     * @throws Exception
     */
    @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 服务端", CharsetUtil.UTF_8));
    }

    /**
     * 通道有读取事件时触发
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("Client---------当前时间:" + new Date().toString());
        log.info("Client---------服务端回复的消息:" + byteBuf.toString(CharsetUtil.UTF_8));
        log.info("Client---------服务端地址:" + ctx.channel().remoteAddress());
    }

    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}