package com.ninggc.iodemo.nio;

import com.ninggc.iodemo.MyIoUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NioMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        nio();
    }

    // 两个阻塞方法,accept和read,nio中可以将这两个方法设置为非阻塞,无事件的情况下返回-1
    private static void nio() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(9000));

        Selector selector = Selector.open();
        // 将channel注册到selector，将设置为ACCEPT模式
        channel.register(selector, SelectionKey.OP_ACCEPT);

        // 设置channel非阻塞
        while (true) {
            // 阻塞方法，轮询监听channel的key
            int select = selector.select();
            System.out.println("after event happened");

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 处理事件，处理完之后删除以防止被重复处理
                MyIoUtil.handleKey(selectionKey);
                iterator.remove();
            }

        }
    }
}
