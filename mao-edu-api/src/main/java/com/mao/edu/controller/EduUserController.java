package com.mao.edu.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import com.mao.edu.entity.EduUser;
import com.mao.edu.entity.EduUserRespDTO;
import com.mao.edu.service.IEduCourseService;
import com.mao.edu.service.IEduUserService;
import com.mao.edu.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mao
 * @since 2023-10-20
 */
@RestController
@Slf4j
public class EduUserController extends BaseApiController
{
    @Autowired
    private IEduUserService iEduUserService;
    @GetMapping("getByTokenUserInfo")
    @ApiOperation(value = "用户令牌接口", notes = "用户令牌接口")
    public BaseResponse getByTokenUserInfo(@RequestHeader String token)
    {

        if (StringUtils.isEmpty(token))
        {
            log.error("[token is null]");
            return setResultError("token is null");
        }
        String redisValue = RedisUtils.getString(token);
        if (StringUtils.isEmpty(redisValue))
        {
            return setResultError("token error");
        }
        Integer userId = Integer.valueOf(redisValue);
        EduUser idEduUser = iEduUserService.findByUserIdEduUser(userId);
        EduUserRespDTO eduUserRespDTO = BeanUtil.toBean(idEduUser, EduUserRespDTO.class);
        return setResultSuccessData(eduUserRespDTO);
    }

}
