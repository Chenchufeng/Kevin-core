import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: Kevin
 * @Date: 2021/9/23 21:51
 * @Description:
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try {
            URL url = TestByteBuffer.class.getClassLoader().getResource("data.txt");
            FileChannel fileChannel = new FileInputStream(new File(url.getFile())).getChannel();
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocate(10);
                int len = fileChannel.read(buffer); //从channel读取数据，写入buffer
//                log.debug("读取到的字节数{}", len);
                if (len == -1) {
                    break;
                }
                buffer.flip(); //切换至读模式
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.println((char) b);
//                    log.debug("实际字节{}", (char) b);
                }
                buffer.clear(); //切换为写模式
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}