package com.atguigu.netty.异步测试;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.log4j.Logger;


/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/13 10:02
 * @Version 1.0
 **/

public class NettyClient {
    private static Logger log = Logger.getLogger(NettyServerHandler.class);
    public static void main(String[] args) throws InterruptedException {
        // 客户端事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            // 创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();

            // 使用链式编程进行设置
            bootstrap.group(eventExecutors) //设置线程组
                    .channel(NioSocketChannel.class)    //设置客户端通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            log.info("Client---------客户端已就绪");

            // 启动客户端连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7001).sync();
            // 监听关闭通道
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}