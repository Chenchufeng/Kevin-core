package Streams;

import java.util.Base64;

/**
 * @Author: chufeng Chen
 * @Description:  通过Base64 将String转换成byte[]或者byte[]转换成String[Java 8]
 * @Date:Create：in 2021/3/13 15:51
 */
public class StringByteArrayExamples {
    public static void main(String[] args) {
        byte[] bytes="Kevin C F chen".getBytes();
        //Base64 Encoded
        String s = Base64.getEncoder().encodeToString(bytes);
        //Base64 Decoded
        byte[] decode = Base64.getDecoder().decode(s);

        System.out.println(new String(decode));
    }
}
