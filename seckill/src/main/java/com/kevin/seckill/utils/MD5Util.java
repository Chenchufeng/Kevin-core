package com.kevin.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/26 22:13
 */
@Component
public class MD5Util {
    private static final String salt="1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    //用户从客户端输入的明文密码传到Java后端的第一次md5加密
    public static String inputPassToFromPass(String inputPass){
        String str=salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    //后端拿到的第一次加密后存到数据库做第二次md5加密
    public static String fromPassToDBPass(String fromPass,String salt){
        String str=salt.charAt(0)+salt.charAt(2) + fromPass + salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    //直接从客户端到数据库的两次md5加密
    public static String inputPassToDBPass(String inputPass,String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = fromPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //ce21b747de5af71ab5c2e20ff0a60eea
        System.out.println(inputPassToFromPass("123456"));
        //0687f9701bca74827fcefcd7e743d179
        System.out.println(fromPassToDBPass("ce21b747de5af71ab5c2e20ff0a60eea","1a2b3c4d"));
        //0687f9701bca74827fcefcd7e743d179
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }
}
