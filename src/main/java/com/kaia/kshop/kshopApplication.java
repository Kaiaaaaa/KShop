package com.kaia.kshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kaia.kshop.mapper")
public class kshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(kshopApplication.class,args);
    }

}
