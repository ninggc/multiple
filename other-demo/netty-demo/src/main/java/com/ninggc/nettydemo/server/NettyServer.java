package com.ninggc.nettydemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer extends ChannelInboundHandlerAdapter {

    public static final int PORT = 9000;

    public static void main(String[] args) throws Throwable {
        // 创建两个线程组，子线程数目默认是cpu核心数量的两倍
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建服务器端的启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 设置两个线程组
            serverBootstrap.group(bossGroup, workerGroup)
                // 使用NioServerSocketChannel作为服务器的通道实现
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new NettyServer());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 创建通道初始化对象，设置初始化参数
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyServerHandler());
                    }
                })
            ;

            // Bind and start to accept incoming connections.
            // 绑定一个端口并同步
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();

            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("bind success");
                    } else {
                        System.out.println("bind failed");
                    }
                }
            });

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, java.lang.Object msg) throws Exception {
        log.info("接收到msg: " + msg);
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, java.lang.Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    private static class NettyServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("接收到msg: " + msg);
            super.channelRead(ctx, msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            super.channelReadComplete(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }
}
