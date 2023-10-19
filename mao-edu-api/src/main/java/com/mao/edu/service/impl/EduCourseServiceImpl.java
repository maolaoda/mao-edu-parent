package com.mao.edu.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mao.edu.constant.Constants;
import com.mao.edu.core.cache.LocalCache;
import com.mao.edu.entity.EduCourse;
import com.mao.edu.entity.EduCourseReqDTO;
import com.mao.edu.entity.EduCourseRespDTO;
import com.mao.edu.mapper.EduCourseMapper;
import com.mao.edu.service.IEduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyao
 * @date 2023-10-19 09:46
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements IEduCourseService
{
    @Autowired
    private EduCourseMapper eduCourseMapper;

    @Override
    public List<EduCourse> getAllEduCourse() {
        QueryWrapper<EduCourse> eduCourseQueryWrapper = new QueryWrapper<>();
        return eduCourseMapper.selectList(eduCourseQueryWrapper);
    }

    @Override
    public List<EduCourseRespDTO> searchCacheCourseList(EduCourseReqDTO eduCourseReqDto)
    {
        List<EduCourseRespDTO> eduCourseRespList = new ArrayList<>();
        eduCourseRespList = LocalCache.get(
           Constants.COURSE_ALLCOURSELIST,
            eduCourseRespList);
        if (CollectionUtils.isEmpty(eduCourseRespList)) {
            log.error("[从缓存中为查找到eduCourseRespList数据]");
            return null;
        }
        // 根据条件搜索
        Stream<EduCourseRespDTO> stream = eduCourseRespList.stream();
        String courseName = eduCourseReqDto.getCourseName();
        // 根据课程名称搜索
        if (!StringUtils.isEmpty(courseName)) {
            stream = stream.filter(c ->
                StrUtil.containsIgnoreCase(c.getCourseName(), (courseName)));
        }
        // 根据课程id查找
        Integer subjectId = eduCourseReqDto.getSubjectId();
        if (subjectId != null) {
            stream = stream.filter((c) -> c.getSubjectId().equals(subjectId));
        }
        //根据最后更新时间排序 返回对应的list集合
        return stream.sorted(Comparator.comparing(EduCourseRespDTO::getUpdateTime))
            .collect(Collectors.toList());
    }
}