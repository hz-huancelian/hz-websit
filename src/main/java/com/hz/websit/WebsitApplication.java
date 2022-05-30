package com.hz.websit;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.hz.websit.mapper")
public class WebsitApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsitApplication.class, args);
    }

}
