package com.mao.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mao.edu.entity.EduCourse;
import com.mao.edu.entity.EduCourseReqDTO;
import com.mao.edu.entity.EduCourseRespDTO;

import java.util.List;

/**
 * @author chenyao
 * @date 2023-10-19 09:45
 */
public interface IEduCourseService extends IService<EduCourse>
{
    /**
     * 查询所有的课程列表
     *
     * @return
     */
    List<EduCourse> getAllEduCourse();

    List<EduCourseRespDTO> searchCacheCourseList(EduCourseReqDTO eduCourseReqDto);
}
