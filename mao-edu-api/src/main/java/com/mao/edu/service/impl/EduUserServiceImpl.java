package com.mao.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mao.edu.entity.EduUser;
import com.mao.edu.mapper.EduUserMapper;
import com.mao.edu.service.IEduUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mao
 * @since 2023-10-20
 */
@Service
public class EduUserServiceImpl extends ServiceImpl<EduUserMapper, EduUser> implements IEduUserService {

    @Autowired
    private EduUserMapper eduUserMapper;
    @Override
    public EduUser findByUserNameEduUser(String userName)
    {
        LambdaQueryWrapper<EduUser> eduUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        eduUserLambdaQueryWrapper.eq(EduUser::getUserName,userName);
        EduUser eduUser = eduUserMapper.selectOne(eduUserLambdaQueryWrapper);
        return eduUser;
    }

    @Override
    public EduUser findByUserIdEduUser(Integer userId)
    {
        return eduUserMapper.selectById(userId);
    }
}
