package com.mao.edu.service;

import com.mao.edu.entity.UserLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mao
 * @since 2023-10-21
 */
public interface IUserLoginLogService extends IService<UserLoginLog> {

    void insertUserLogin(UserLoginLog userLoginLog);
}
