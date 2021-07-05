package com.kevin.seckill.utils;

import java.util.UUID;


/**
 * UUID工具类用于生成session
 * @author Chufeng Chen
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
