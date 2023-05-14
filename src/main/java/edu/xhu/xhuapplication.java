package edu.xhu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.xhu.mapper")
public class xhuapplication {

    public static void main(String[] args) {
        SpringApplication.run(xhuapplication.class, args);

    }
}
