package com.kevin.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/5/26 21:48
 */
@Configuration
public class RedisConfig {
    //编写自己的redisTemplate
    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
