package com.mao.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mao.edu.entity.EduCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 课程表 Mapper 接口
 * @author chenyao
 * @date 2023-10-19 09:46
 */
@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse>
{

}
