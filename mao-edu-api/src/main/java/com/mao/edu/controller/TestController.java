package com.mao.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyao
 * @date 2023-10-18 09:11
 */
@RestController
public class TestController
{
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
