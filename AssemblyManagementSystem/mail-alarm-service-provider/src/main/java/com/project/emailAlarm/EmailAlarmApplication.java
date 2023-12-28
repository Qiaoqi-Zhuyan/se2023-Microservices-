package com.project.emailAlarm;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class EmailAlarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailAlarmApplication.class, args);
    }
}
