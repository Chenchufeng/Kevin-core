package com.kevin;


import com.kevin.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
//import com.kevin.config.RedisConfig;



@SpringBootTest
class RedisSpringbootApplicationTests {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void test1(){
        redisUtil.set("name", "kuangshen");
        System.out.println(redisUtil.get("name"));
    }
}
