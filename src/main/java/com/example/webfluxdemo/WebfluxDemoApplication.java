package com.example.webfluxdemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaobox
 */
@SpringBootApplication
public class WebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxDemoApplication.class, args);
    }


    @Bean
    ApplicationRunner applicationRunner() {

        return args -> {

            System.out.println("this is Application Runner ");
        };
    }

}
