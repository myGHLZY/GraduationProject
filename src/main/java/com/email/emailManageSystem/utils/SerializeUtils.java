package com.email.emailManageSystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @author userlzy
 * @version 1.0
 * @description: 序列化器
 * @date 2025/3/23 14:13
 */

@Component
public class SerializeUtils {

    public static final ObjectMapper mapper = new ObjectMapper();


    // 序列化
    public static <T> String serialize(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    // 反序列化
    public static <T> T deserialize(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }
}