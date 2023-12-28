package com.zr.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.zr.book.mapper")
public class bookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(bookServiceApplication.class, args);
    }

}
