package com.project.exceptionHandle;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.project.exceptionHandle.mapper")
@SpringBootApplication
@EnableDubbo
public class ExceptionHanleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionHanleApplication.class, args);
    }
}
