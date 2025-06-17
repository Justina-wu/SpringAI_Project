package com.wjy.ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wjy.ai.mapper")
@SpringBootApplication
public class AiSpringAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiSpringAiApplication.class, args);
    }

}
