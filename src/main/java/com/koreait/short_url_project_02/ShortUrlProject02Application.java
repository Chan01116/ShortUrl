package com.koreait.short_url_project_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShortUrlProject02Application {

    public static void main(String[] args) {
        SpringApplication.run(ShortUrlProject02Application.class, args);
    }

}