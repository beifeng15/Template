package com.atguigu.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/11/30 16:54
 * @Version 1.0
 **/
public class ClientEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        Thread.sleep(2000);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()) +"客户端-编码器-被调用");

        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
