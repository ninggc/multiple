package com.ninggc.mytomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8180);
        System.out.println("start success");
        while (!serverSocket.isClosed()) {
            final Socket socket = serverSocket.accept();
            threadPool.submit(new Runnable() {
                public void run() {
                    try {

                        //region 读取请求
                        InputStream inputStream = socket.getInputStream();
                        System.out.println("request received");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                        String msg = null;
                        while ((msg = bufferedReader.readLine()) != null) {
                            if (msg.length() == 0) {
                                break;
                            }
                            System.out.println(msg);
                        }
                        //endregion

                        //region 发出响应
                        String resp = "Hello it's my tomcat";
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
//                    outputStream.write("Content-Type:application/json\r\n".getBytes());
//                    outputStream.write("Content-Length:10\r\n\r\n".getBytes());
//                    outputStream.write(("{\"name\":\"" + resp + "\"}").getBytes());
                        outputStream.flush();
                        //endregion

                        socket.close();
                        System.out.println("request closed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
