package com.ninggc.iodemo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioMain {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9000);
        while (true) {
            // accept方法阻塞
            Socket clientSocket = socket.accept();
            System.out.println("get msg from client");

            byte[] bytes = new byte[1024];
            int read = clientSocket.getInputStream().read(bytes);
            if (read != -1) {
                System.out.println(new String(bytes));
            }

            clientSocket.getOutputStream().write("respect for client".getBytes());
            clientSocket.getOutputStream().flush();


            System.out.println("reply client");
        }
    }
}
