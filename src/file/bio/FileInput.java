package file.bio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
    public static void main(String[] args) {
        try {
            FileInputStream reader = new FileInputStream("test");
//            int temp;
//            while((temp = reader.read()) != -1){
//                System.out.println((char)temp);
//            }
            byte[] temp = new byte[reader.available()];
            int result = reader.read(temp);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
