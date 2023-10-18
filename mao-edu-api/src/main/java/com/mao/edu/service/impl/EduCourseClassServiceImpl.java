package com.mao.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mao.edu.entity.EduCourseClass;
import com.mao.edu.mapper.EduCourseClassMapper;
import com.mao.edu.service.IEduCourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mao
 * @since 2023-10-18
 */
@Service
public class EduCourseClassServiceImpl extends ServiceImpl<EduCourseClassMapper, EduCourseClass> implements
    IEduCourseClassService
{
    @Autowired
    EduCourseClassMapper eduCourseClassMapper;

    @Override
    public List<EduCourseClass> getAllCourseClass()
    {
        QueryWrapper<EduCourseClass> objectQueryWrapper = new QueryWrapper<>();
        List<EduCourseClass> eduCourseClasses = eduCourseClassMapper.selectList(objectQueryWrapper);
        return eduCourseClasses;
    }
}
