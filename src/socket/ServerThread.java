package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream writer = new PrintStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                writer.println("hello!");
                String line = reader.readLine();
                if(line.equals("bye")){
                    System.out.println("client：" + line);
                    writer.close();
                    reader.close();
                    socket.close();
                    break;
                }else {
                    System.out.println("client：" + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
