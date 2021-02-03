package com.ninggc.iodemo.aio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel =
                AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(9000));

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                serverSocketChannel.accept(attachment, this);
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                socketChannel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @SneakyThrows
                    @Override
                    public void completed(Integer result, ByteBuffer byteBuffer) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array()));
                        socketChannel.write(ByteBuffer.wrap("pleasure to received you msg!\n".getBytes()));
                        socketChannel.close();
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println("failed");
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed");
            }
        });

        Thread.sleep(Integer.MAX_VALUE);
    }
}
