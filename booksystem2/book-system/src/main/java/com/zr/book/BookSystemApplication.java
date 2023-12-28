package com.zr.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;

@SpringBootApplication
@EnableDubboConfig
public class BookSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookSystemApplication.class, args);
    }

}
