package com.yxr.automobile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启feign的调用
@EnableFeignClients
//扫描mybatis的mapper.xml
@MapperScan("com.yxr.automobile.dao")



public class AutomobileApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomobileApplication.class, args);
    }

}
