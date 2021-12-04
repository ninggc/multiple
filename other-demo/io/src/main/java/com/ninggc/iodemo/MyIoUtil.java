package com.ninggc.iodemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyIoUtil {
    public static void handleKey(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()) {
            System.out.println("acceptable");
            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
            SocketChannel sc = ssc.accept();

            sc.configureBlocking(false);
            sc.register(selectionKey.selector(), SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            System.out.println("readable");
            SocketChannel channel = (SocketChannel) selectionKey.channel();

            ByteBuffer buffer = ByteBuffer.allocate(4096);
            int len = channel.read(buffer);
            if (len != -1) {
                // 接收到响应信息
                System.out.println("print msg from client: " + new String(buffer.array()));
            }
            // 写入响应信息
            channel.write(ByteBuffer.wrap("reply to client".getBytes()));

            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } else if (selectionKey.isWritable()) {
            System.out.println("writeable");
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }
}
