package com.email.emailManageSystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author userlzy
 * @version 1.0
 * @description: Redis的工具类
 * @date 2025/3/18 21:02
 */

public class RedisUtils {

    private static final StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();


    // 存放
    public static void setString(String key, String val){
        stringRedisTemplate.opsForValue().set(key, val);
    }

    public static void setString(String key, String val,long timeout, TimeUnit unit){
        stringRedisTemplate.opsForValue().set(key, val, timeout, unit);
    }

    public static<T> void setObject(String key, T object) throws JsonProcessingException {
        // 序列化
        String serialize = SerializeUtils.serialize(object);
        stringRedisTemplate.opsForValue().set(key, serialize);
    }

    public static<T> void setObject(String key, T object, long timeout, TimeUnit unit) throws JsonProcessingException {
        // 序列化
        String serialize = SerializeUtils.serialize(object);
        stringRedisTemplate.opsForValue().set(key, serialize, timeout, unit);
    }

    // 取出
    public static String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static<T> T getObject(String key, Class<T> clazz) throws JsonProcessingException {
        return SerializeUtils.deserialize(getString(key), clazz);
    }

    // 设置过期时间
    public static void expire(String key, long timeout, TimeUnit unit){
        stringRedisTemplate.expire(key,timeout,unit);
    }

}