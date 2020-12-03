package com.ninggc.jdkdemo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class io {
    public static void main(String[] args) throws IOException {
        bio();
        // nio();

        // multiplexing();
    }

    private static void multiplexing() throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(8082));
        Selector selector = Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            Set<SelectionKey> keys = selector.keys();
            System.out.println(keys.size());

            // 有没有事件？
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter;
                while ((iter = selectionKeys.iterator()).hasNext()) {
                    SelectionKey selectionKey = iter.next();
                    iter.remove();
                    if (selectionKey.isAcceptable()) {
                        // 处理掉事件
                        acceptHandle(selectionKey, selector);
                    } else if (selectionKey.isReadable()) {

                    }
                }
            }
        }
    }

    private static void acceptHandle(SelectionKey selectionKey, Selector selector) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        // int read;
        // if ((read = socketChannel.read(buffer)) > 0) {
        //     buffer.flip();
        // }
        socketChannel.register(selector, SelectionKey.OP_READ, buffer);
    }

    private static void nio() throws IOException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel open = ServerSocketChannel.open();
        open.bind(new InetSocketAddress(8082));
        open.configureBlocking(false);

        while (true) {
            SocketChannel accept = open.accept();
            if (accept != null) {
                accept.configureBlocking(false);
                System.out.println(accept.socket().getPort());
                clients.add(accept);
            }

            ByteBuffer allocate = ByteBuffer.allocate(4096);
            for (SocketChannel client : clients) {
                int read;
                if ((read = client.read(allocate)) > 0) {
                    // flip函数？
                    allocate.flip();
                }
            }
        }
    }

    private static void bio() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true) {
            Socket accept = serverSocket.accept();

            System.out.println("connected");
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String readLine = bufferedReader.readLine();
            System.out.println(readLine);

            OutputStream outputStream = accept.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("thanks");

            inputStream.close();
            outputStream.close();
            accept.close();
        }
    }
}
