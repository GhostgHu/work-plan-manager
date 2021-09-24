package com.shimengjie.wpm.app.config;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.shimengjie.wpm.common.serializer.CustomLocalDateTimeDeserializer;
import com.shimengjie.wpm.common.serializer.CustomLocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shimengjie
 */
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        SimpleModule timeModule = new JavaTimeModule()
                .addDeserializer(LocalDateTime.class, new CustomLocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .addSerializer(LocalDateTime.class, new CustomLocalDateTimeSerializer(true));
        return Jackson2ObjectMapperBuilder.json().createXmlMapper(false).serializationInclusion(Include.NON_NULL)
                .failOnUnknownProperties(false)
                .modules(new ParameterNamesModule(), new Jdk8Module(), timeModule)
                .build();
    }

}
