package com.yxr.car_type;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.yxr.car_type.dao")
@EnableFeignClients
@EnableEurekaClient
public class CarTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarTypeApplication.class, args);
    }

}
