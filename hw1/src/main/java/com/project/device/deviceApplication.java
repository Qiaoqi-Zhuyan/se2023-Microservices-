package com.project.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.project.device.mapper")
public class deviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(deviceApplication.class, args);
    }

}