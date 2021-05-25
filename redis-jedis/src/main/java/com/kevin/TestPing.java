package com.kevin;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/5/25 22:27
 */
public class TestPing {
    public static void main(String[] args) {
        /**
         * 在redis-server.exe目录下，打开命令行
         * redis-server.exe redis.windows.conf 开启local redis server
         */
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.ping());
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","kevin");
        //开启事务
        Transaction transaction = jedis.multi();
        String result = jsonObject.toJSONString();
        try {
            transaction.set("user1",result);
            transaction.set("user2",result);
//            int i=1/0;
            transaction.exec();
        } catch (Exception e) {
            transaction.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }

    }
}
