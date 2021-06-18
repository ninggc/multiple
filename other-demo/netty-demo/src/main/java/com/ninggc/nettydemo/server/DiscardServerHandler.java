package com.ninggc.nettydemo.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
//            while (byteBuf.isReadable()) {
//                log.info(String.valueOf((char) byteBuf.readByte()));
//            }

            log.info("received msg: {}", ((ByteBuf) msg).toString(CharsetUtil.UTF_8));

            // do response
            // write operation will auto do release msg
            ctx.write(msg);
            ctx.flush();
        } finally {
//            ReferenceCountUtil.release(msg);
            log.info("finally");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
