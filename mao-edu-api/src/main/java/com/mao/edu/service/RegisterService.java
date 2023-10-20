package com.mao.edu.service;

import com.mao.edu.entity.RegisterReqDTO;

public interface RegisterService
{
    /**
     * 用户注册接口
     * @return
     */
    Boolean register(RegisterReqDTO registerReqDTO);
}
