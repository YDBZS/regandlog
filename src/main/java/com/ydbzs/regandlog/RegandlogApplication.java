package com.ydbzs.regandlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.ydbzs")
@MapperScan("com.ydbzs.mapper")
public class RegandlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegandlogApplication.class, args);
    }

}
