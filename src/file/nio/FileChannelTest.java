package file.nio;
/*
 * create by zk
 * 19-4-18
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        File inFile = new File("input");
        File outFile = new File("output");

        FileChannel inChannel = new FileInputStream(inFile).getChannel();
        FileChannel outChannel = new FileOutputStream(outFile).getChannel();

        outChannel.transferFrom(inChannel,0,inFile.length()); //零拷贝

        MappedByteBuffer mappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inFile.length());

        Charset charset = Charset.forName("utf-8");

        outChannel.write(mappedByteBuffer);

        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder=charset.newEncoder();


        CharBuffer charBuffer = decoder.decode(mappedByteBuffer);
        ByteBuffer byteBuffer = encoder.encode(charBuffer);

    }
}
