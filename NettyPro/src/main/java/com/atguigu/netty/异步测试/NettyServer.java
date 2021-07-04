package com.atguigu.netty.异步测试;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.apache.log4j.Logger;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/13 10:02
 * @Version 1.0
 **/

public class NettyServer {
    private static Logger log = Logger.getLogger(NettyServerHandler.class);
    public static void main(String[] args) throws InterruptedException {

        // 创建BossGroup和WorkerGroup
        // boss处理连接请求
        // worker和客户端进行业务处理
        // 二者都是无限循环
        // 如果不指定数量，默认是cpu的核数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 创建服务器端启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 使用链式编程进行设置
            bootstrap.group(bossGroup, workerGroup)  //设置两个线程组
                    .channel(NioServerSocketChannel.class)    //使用NioSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)  //设置线程队列的连接数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  //
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 为pipline设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            log.info("Server---------服务端已就绪");
            // 绑定一个端口并同步
            int port = 7001;
            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            // 监听关闭通道的动作
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
