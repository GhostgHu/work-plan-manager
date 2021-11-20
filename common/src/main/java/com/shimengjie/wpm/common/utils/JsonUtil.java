package com.shimengjie.wpm.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shimengjie
 * @date 2021/11/10 15:47
 **/
@Slf4j
public class JsonUtil {

    public static ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        SimpleModule timeModule = new JavaTimeModule()
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateUtil.DATETIME_FORMAT)))
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateUtil.DATETIME_FORMAT_WITH_MILLI)))
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateUtil.DATETIME_FORMAT)))
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateUtil.DATETIME_FORMAT_WITH_MILLI)));
        OBJECT_MAPPER.registerModule(timeModule).registerModule(new Jdk8Module()).registerModule(new ParameterNamesModule());

    }

    /**
     * json转成pojo对象
     *
     * @param json      json 字符串
     * @param valueType 要转换的类
     * @return T
     */
    public static <T> T fromJson(String json, Class<T> valueType) {
        if (null == json) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            log.info("fromJson error", e);
            return null;
        }
    }

    /**
     * json转成泛型类
     *
     * @param json             json
     * @param parametrized     最外层泛型类 如 List.class
     * @param parameterClasses 泛型参数 如 List<String> 中的String.class
     * @param <T>              如List<String>
     * @return 如果转换失败.返回null
     */
    public static <T> T fromJson(String json, Class<?> parametrized, Class<?>... parameterClasses) {
        try {
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses));
        } catch (IOException e) {
            log.warn("json转换失败", e);
            return null;
        }
    }

    public static <T> T fromJson(String json, ObjectMapper objectMapper, Class<T> valueType) {
        if (null == json) {
            return null;
        }
        try {
            T value = objectMapper.readValue(json, valueType);
            return value;
        } catch (IOException e) {
            log.info("fromJson error", e);
            return null;
        }
    }

    /**
     * 把对象转换成 json 自放醋换
     *
     * @param obj 要转换的对象
     * @return json 字符串
     */
    public static String toJson(Object obj) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.info("toJson error", e);
            return null;
        }
        return json;
    }

    public static String toJson(Object obj, ObjectMapper objectMapper) {
        String json = null;
        if (objectMapper == null) {
            return null;
        }
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.info("toJson error", e);
        }
        return json;
    }
}
