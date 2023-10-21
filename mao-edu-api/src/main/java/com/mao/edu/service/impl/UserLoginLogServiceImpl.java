package com.mao.edu.service.impl;

import com.mao.edu.entity.UserLoginLog;
import com.mao.edu.mapper.UserLoginLogMapper;
import com.mao.edu.service.IUserLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mao
 * @since 2023-10-21
 */
@Slf4j
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog>
    implements IUserLoginLogService
{
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    @Transactional
    @Async
    public void insertUserLogin(UserLoginLog userLoginLog)
    {
        int insertResult = userLoginLogMapper.insert(userLoginLog);
        log.info("[插入数据：insertResult:{}]", insertResult);

    }
}
