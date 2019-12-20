package com.github.netyjq.archetype;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot bootstrap
 * @date 2017/6/7
 * @author netyjq@gmail.com
 */
@SpringBootApplication
@MapperScan("com.github.netyjq.archetype.mapper")
public class ApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);
    }

}

