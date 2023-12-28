package com.project.assemblyManagementSystem;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
@MapperScan("com.project.assemblyManagementSystem.mapper")
public class AssemblyManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssemblyManageApplication.class, args);
    }

}
