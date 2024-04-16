package com.example.redis.demoRedis.configuration;

//@org.springframework.context.annotation.Configuration
//@org.springframework.cache.annotation.EnableCaching
public class CachingConfiguration {

    @org.springframework.context.annotation.Bean
    public org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory lettuceConnectionFactory(){
        org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory lettuceConnectionFactory=
                new org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory();
        lettuceConnectionFactory.setPassword("");
        lettuceConnectionFactory.setClientName("default");
        lettuceConnectionFactory.setHostName("");
        lettuceConnectionFactory.setPort(786756);
        return lettuceConnectionFactory;
    }

    public org.springframework.data.redis.core.RedisTemplate<String,Object>redisTemplate(){
        org.springframework.data.redis.core.RedisTemplate<String,Object> redisTemplate=new org.springframework.data.redis.core.RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        return redisTemplate;
    }
}
