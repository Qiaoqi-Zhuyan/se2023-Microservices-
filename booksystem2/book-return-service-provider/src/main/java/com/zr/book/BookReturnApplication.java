package com.zr.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;


@MapperScan("com.zr.book.mapper")
@SpringBootApplication
@EnableDubbo
public class BookReturnApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookReturnApplication.class, args);
    }

}
