package com.mao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author maolaoda
 */
@SpringBootApplication
@EnableAsync
@MapperScan("com.mao.edu.mapper")
public class AppEdu
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppEdu.class);
    }
}