package com.mao.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author chenyao
 * @date 2023-10-20 11:18
 */
@Data
public class EduUserRespDTO
{

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("显示名 （昵称）")
    private String showName;

    @ApiModelProperty("性别  1男  2女")
    private Boolean sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否可用 1正常  2冻结")
    private Boolean isAvalible;

    @ApiModelProperty("用户头像")
    private String picImg;

    @ApiModelProperty("个人中心用户背景图片")
    private String bannerUrl;
}
