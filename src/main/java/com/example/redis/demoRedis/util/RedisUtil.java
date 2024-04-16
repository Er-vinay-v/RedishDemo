package com.example.redis.demoRedis.util;

//@org.springframework.stereotype.Component
public class RedisUtil {
    @org.springframework.beans.factory.annotation.Autowired
    org.springframework.data.redis.core.RedisTemplate<String,Object>redisTemplate;

    public void setNonExperiableRedisKey(String key,Object value){
        System.out.printf("Inside setNonExperiableRedisKey method");
        redisTemplate.opsForValue().set(key,value);
        System.out.printf("Inside setNonExperiableRedisKey method");
    }

    public Object getNonExperiableRedisValue(String key){
        System.out.printf("Inside setNonExperiableRedisKey method");
        return redisTemplate.opsForValue().get(key);
    }
}
