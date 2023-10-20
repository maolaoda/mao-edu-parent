package com.mao.edu.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenyao
 * @date 2023-10-20 10:33
 */
@Data
public class RegisterReqDTO
{

    private String userName;


    private String password;
}
