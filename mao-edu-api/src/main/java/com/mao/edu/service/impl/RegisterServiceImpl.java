package com.mao.edu.service.impl;

import com.mao.edu.constant.Constants;
import com.mao.edu.entity.EduUser;
import com.mao.edu.entity.RegisterReqDTO;
import com.mao.edu.mapper.EduUserMapper;
import com.mao.edu.service.IEduUserService;
import com.mao.edu.service.RegisterService;
import com.mao.edu.utils.MD5Utils;
import com.mao.edu.utils.SaltUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author chenyao
 * @date 2023-10-20 10:34
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService
{
    @Autowired
    private EduUserMapper eduUserMapper;
    @Autowired
    private IEduUserService eduUserService;
    @Override
    public Boolean register(RegisterReqDTO registerReqDTO)
    {
        // 1.验证码参数
        String userName = registerReqDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            log.error("[userName is null]");
            return Boolean.FALSE;
        }
        // 根据名称从db查找到用户信息
        EduUser dbEduUser = eduUserService.findByUserNameEduUser(userName);
        if (dbEduUser != null) {
            log.error("[从数据库中查找到数据:{},无需重复注册]", registerReqDTO);
            return Boolean.FALSE;
        }
        String password = registerReqDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            log.error("[password is null]");
            return Boolean.FALSE;
        }
        // 用户密码+盐值
        String salt = SaltUtils.getSalt();
        String newPassword = MD5Utils.md5(password + salt);
        EduUser eduUser = new EduUser();
        eduUser.setUserName(userName);
        eduUser.setPassword(newPassword);
        eduUser.setUserSalt(salt);
        return eduUserMapper.insert(eduUser) > Constants.DB_INSERT_RESULT_BIGZERO;
    }
}
