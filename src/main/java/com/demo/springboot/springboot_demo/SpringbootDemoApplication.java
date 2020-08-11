package com.demo.springboot.springboot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//实现接口的动态绑定
@MapperScan(basePackages = "com.demo.springboot.mybatis.mapper")
//扫描Service
@ComponentScan(basePackages = {"com.demo.springboot.mybatis.service",
        "com.demo.springboot.mybatis.controller"})
//开启注解事务
@EnableTransactionManagement
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
