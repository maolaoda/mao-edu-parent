package com.mao.edu.controller;

import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import com.mao.edu.entity.EduUser;
import com.mao.edu.entity.LoginReqDTO;
import com.mao.edu.service.IEduUserService;
import com.mao.edu.utils.MD5Utils;
import com.mao.edu.utils.RedisUtils;
import com.mao.edu.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author chenyao
 * @date 2023-10-20 10:55
 */
@Slf4j
@RestController
public class LoginController extends BaseApiController
{
    @Autowired
    private IEduUserService eduUserService;

    /**
     * 用户登录
     *
     * @param loginReqDto
     * @return
     */
    @PostMapping("login")
    public BaseResponse login(@RequestBody LoginReqDTO loginReqDto) {
        String userName = loginReqDto.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null]");
            return setResultError("userName is null");
        }
        // 查询用户信息
        EduUser dbEduUser = eduUserService.findByUserNameEduUser(userName);
        if (dbEduUser == null) {
            log.error("[未查找到用户信息]");
            return setResultError("账户或者密码错误");
        }
        // 获取用户盐值
        String userSalt = dbEduUser.getUserSalt();
        String newPwd = MD5Utils.md5(loginReqDto.getPassword() + userSalt);
        // 比对数据库密码
        if (!newPwd.equals(dbEduUser.getPassword())) {
            return setResultError("账户或者密码错误");
        } // 生产对应的用户token
        String userToken = TokenUtils.getToken();
        Integer userId = dbEduUser.getUserId();
        RedisUtils.setString(userToken, userId);
        HashMap<String, String> result = new HashMap<>();
        result.put("userToken", userToken);
        return setResultSuccessData(result);
    }
}
