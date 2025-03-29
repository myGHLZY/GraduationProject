package com.email.emailManageSystem.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author userlzy
 * @version 1.0
 * @description: 用来专门处理密码的序列化器
 * @date 2025/3/25 22:32
 */
public class PasswordSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("**********");
    }
}