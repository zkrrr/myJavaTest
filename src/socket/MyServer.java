package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8089);

        while (true) {
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }
}
