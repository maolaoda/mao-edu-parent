package com.mao.edu.service;

import com.mao.edu.entity.EduUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mao
 * @since 2023-10-20
 */
public interface IEduUserService extends IService<EduUser> {

    EduUser findByUserNameEduUser(String userName);

    EduUser findByUserIdEduUser(Integer userId);
}
