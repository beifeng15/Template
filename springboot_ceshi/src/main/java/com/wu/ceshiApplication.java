package com.wu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Author Mr.Wu
 * @Date 2020/6/7 11:24
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan("com.wu.dao")
public class ceshiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ceshiApplication.class, args);
    }
}
