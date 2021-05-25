package com.kevin;

import redis.clients.jedis.Jedis;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/5/25 22:27
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.ping());
    }
}
