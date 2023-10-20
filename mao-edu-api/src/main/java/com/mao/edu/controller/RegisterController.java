package com.mao.edu.controller;

import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import com.mao.edu.entity.RegisterReqDTO;
import com.mao.edu.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyao
 * @date 2023-10-20 10:38
 */
@RestController
@Slf4j
public class RegisterController extends BaseApiController
{
    @Autowired
    private RegisterService registerService;

    /**
     * 用户注册接口
     *
     * @return
     */
    @PostMapping("register")
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口")
    public BaseResponse register(@RequestBody RegisterReqDTO registerReqDTO) {
        // 1.验证码参数
        String userName = registerReqDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null]");
            return setResultError("userName is null");
        }
        String password = registerReqDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            log.error("[password is null]");
            return setResultError("password is null");
        }
        Boolean registerResult = registerService.register(registerReqDTO);
        return registerResult ? setResultSuccess() : setResultError();
    }
}
