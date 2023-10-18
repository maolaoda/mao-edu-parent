package com.mao.edu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mao.edu.entity.EduCourseClass;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mao
 * @since 2023-10-18
 */
public interface IEduCourseClassService extends IService<EduCourseClass> {
    /**
     * 查询课程列表
     * @return
     */
    List<EduCourseClass> getAllCourseClass();
}
