import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class nio {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8080, 20);
        while (true) {
            Socket accept = socket.accept();
            Thread.sleep(2 * 1000);
        }
    }
}
