package com.mao.edu.controller;

import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyao
 * @date 2023-10-18 09:11
 */
@Slf4j
@RestController
public class TestController extends BaseApiController
{


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test02")
    public BaseResponse test02() {
        return setResultSuccess();
    }

    @GetMapping("/test03")
    public BaseResponse test03(int i) {
        Integer x = 10/i;
        return setResultSuccess();
    }

    @GetMapping("/test04")
    @ApiOperation(value = "测试传递参数", notes = "测试传递参数")
    @ApiImplicitParam(paramType = "query", name = "name", value = "传递name", required = true)
    public BaseResponse test04(String name) {
        log.info("name:{}", name);
        return setResultSuccess();
    }
}
