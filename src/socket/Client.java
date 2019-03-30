package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 8089);
        PrintStream writer = new PrintStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
            String line = in.nextLine();
            String message = reader.readLine();
            System.out.println("server：" + message);
            if(line.equals("bye")){
                writer.println(line);
                writer.close();
                reader.close();
                socket.close();
                break;
            }else {
                writer.println(line);
            }
        }
    }
}
