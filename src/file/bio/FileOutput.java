package file.bio;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

    public static void main(String[] args) {
        try {
            FileOutputStream writer = new FileOutputStream("test",true);//追加的方式写入文件
            //FileOutputStream writer = new FileOutputStream("test");//不追加 覆盖当前位置的字符
            //int temp=78;//把对应的ascii码写到文件里面 大于ascii码的不能识别
            //char temp = 'A';
            byte[] temp = {'0','1','2','3','4','5','6','7','8','9'};
            writer.write(temp);
            //writer.write(temp,2,2);//从哪个位置开始 写几个长度的字节 如果越界报异常
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
