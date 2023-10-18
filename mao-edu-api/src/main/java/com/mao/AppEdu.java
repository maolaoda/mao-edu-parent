package com.mao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maolaoda
 */
@SpringBootApplication
@MapperScan("com.mao.edu.mapper")
public class AppEdu
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppEdu.class);
    }
}