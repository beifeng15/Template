package com.atguigu.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.concurrent.DefaultEventExecutorGroup;

import java.util.concurrent.atomic.AtomicInteger;

public class TestServer {
    static int i =1;
    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
//      AtomicInteger atomicInteger = new AtomicInteger();
        final DefaultEventExecutorGroup eventExecutors = new DefaultEventExecutorGroup(1);

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap
                    .group(bossGroup, workerGroup)
//                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast("MyHttpServerCodec",new HttpServerCodec());
//                            p.addLast(new CountServerHandler(i));
                            //2. 增加一个自定义的handler
                            p.addLast(eventExecutors,new CountServerHandler());
                            p.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(6608).sync();

            System.out.println("atomicInteger"+i);
            
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
