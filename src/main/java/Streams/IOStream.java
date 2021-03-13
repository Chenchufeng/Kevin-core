package Streams;

import java.io.*;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/3/13 14:58
 */
public class IOStream {

    //打开文件，一次读取一个字节
    public static void readFile_1()throws IOException
    {

        FileInputStream fis = new FileInputStream("fos.txt");

        int ch = 0;

        while((ch=fis.read())!=-1)
        {
            System.out.println((char)ch);
        }

        fis.close();
    }

    //打开文件，一次读取多个字节
    public static void readFile_2()throws IOException
    {
        FileInputStream fis = new FileInputStream("G:\\study\\hello.txt");

        byte[] buf = new byte[1024];
        int len = 0;
        while((len=fis.read(buf))!=-1)
        {
            System.out.println(new String(buf,0,len));
        }

        fis.close();

    }

    //打开文件，一次读取刚刚好内容的字节
    public static void readFile_3() throws IOException {
        InputStream inputStream = new FileInputStream(new File("G:\\study\\hello.txt"));
        byte[] buf= new byte[inputStream.available()];
        inputStream.read(buf);
        System.out.println(new String(buf));
        inputStream.close();
    }
    public static void main(String[] args) {
        try {
            IOStream.readFile_1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
