package com.atguigu.netty.异步测试;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;



/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/13 9:41
 * @Version 1.0
 **/

public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    private static Logger log = Logger.getLogger(NettyServerHandler.class);
    /**
     * 读取客户端发送的数据
     * @param ctx 上下文对象（包含 管道pipeline、通道channel、地址）
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        // 将msg转换
        // ByteBuf是netty提供的，NIO的是ByteBuffer
        ByteBuf byteBuf = (ByteBuf) msg;

        log.info("Server---------客户端发送的消息是:" + byteBuf.toString(CharsetUtil.UTF_8));
        log.info("Server---------客户端地址:" + ctx.channel().remoteAddress());

        // 异步任务(任务提交到taskQueue中)
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // 五秒后再发送一条消息
                    Thread.sleep(20000);

                    ctx.writeAndFlush(Unpooled.copiedBuffer("异步消息001", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 用户自定义定时任务（提交到scheduleTaskQueue）
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override public void run() {
                // 五秒后再发送一条消息
                ctx.writeAndFlush(Unpooled.copiedBuffer("异步消息002",CharsetUtil.UTF_8));
            }
        },20, TimeUnit.SECONDS);
    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 向客户端发送数据
        // 对发送的数据进行编码
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello客户端", CharsetUtil.UTF_8);
        // 数据写入缓存并刷新
        ctx.writeAndFlush(byteBuf);
    }

    /**
     * 处理异常，一般是需要关闭通道
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}