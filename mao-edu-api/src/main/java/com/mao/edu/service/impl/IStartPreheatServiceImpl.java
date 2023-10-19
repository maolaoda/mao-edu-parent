package com.mao.edu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mao.edu.constant.Constants;
import com.mao.edu.core.cache.LocalCache;
import com.mao.edu.entity.EduCourse;
import com.mao.edu.entity.EduCourseClass;
import com.mao.edu.entity.EduCourseClassRespDTO;
import com.mao.edu.entity.EduCourseRespDTO;
import com.mao.edu.service.IEduCourseClassService;
import com.mao.edu.service.IEduCourseService;
import com.mao.edu.service.IStartPreheatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyao
 * @date 2023-10-18 17:20
 */
@Slf4j
@Service
public class IStartPreheatServiceImpl  implements IStartPreheatService
{
    @Autowired
    private IEduCourseClassService iEduCourseClassService;
    @Autowired
    private IEduCourseService iEduCourseService;

    @Override
    public void initData() {
        Long startTime = System.currentTimeMillis();
        // 1.初始化课程分类
        initAllCourseClass();
        //2.初始化课程列表加入本地缓存
        initEduCourseList();
        Long ednTime = System.currentTimeMillis();
        log.info("[缓存预热的时间：]" + (ednTime - startTime));
    }
    private void initAllCourseClass() {
        List<EduCourseClass> allCourseClassList = iEduCourseClassService.getAllCourseClass();
        // 将db中数据  do 转化成dto对象存放
        List<EduCourseClassRespDTO> eduCourseClassRespList = BeanUtil.copyToList(allCourseClassList, EduCourseClassRespDTO.class);
        // 将dto对象缓存到jvm内存中
        LocalCache.put(Constants.COURSE_ALLCOURSECLASSLIST, eduCourseClassRespList);
        log.info("1.初始化数据【allCourseClassList：{}】 完成", allCourseClassList);
    }

    private void initEduCourseList() {
        List<EduCourse> allCourseClass = iEduCourseService.getAllEduCourse();
        // 将db中数据  do 转化成dto对象存放
        List<EduCourseRespDTO> eduCourseRespList = BeanUtil.copyToList(allCourseClass, EduCourseRespDTO.class);
        // 将dto对象缓存到jvm内存中
        LocalCache.put(Constants.COURSE_ALLCOURSELIST, eduCourseRespList);
        log.info("1.初始化数据【allCourse：{}】 完成", eduCourseRespList);
    }
}