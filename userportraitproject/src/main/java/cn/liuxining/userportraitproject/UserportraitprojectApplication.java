package cn.liuxining.userportraitproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.liuxining.userportraitproject.mapper")
public class UserportraitprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserportraitprojectApplication.class, args);
    }
}
