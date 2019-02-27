package com.vczyh.heweather;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.vczyh.heweather.dao.mapper")
public class HeweatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeweatherApplication.class, args);
    }

    @Bean
    RestTemplate template(RestTemplateBuilder builder) {
        return builder.build();
    }

}
