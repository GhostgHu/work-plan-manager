package com.shimengjie.wpm.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppApplication.class, args);
        Environment env = context.getEnvironment();
        String appName = env.getProperty("spring.application.name", "app");
        String profile = env.getProperty("spring.profiles.active");
        log.info("====【" + appName + " : " + profile + "】 has been started ====");
    }

}
