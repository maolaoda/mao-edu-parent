package com.mao.edu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mao.edu.constant.Constants;
import com.mao.edu.core.cache.LocalCache;
import com.mao.edu.entity.EduCourseClass;
import com.mao.edu.entity.EduCourseClassRespDTO;
import com.mao.edu.service.IEduCourseClassService;
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

    @Override
    public void initData() {
        // 1.初始化课程分类
        initAllCourseClass();
    }
    private void initAllCourseClass() {
        List<EduCourseClass> allCourseClassList = iEduCourseClassService.getAllCourseClass();
        // 将db中数据  do 转化成dto对象存放
        List<EduCourseClassRespDTO> eduCourseClassRespList = BeanUtil.copyToList(allCourseClassList, EduCourseClassRespDTO.class);
        // 将dto对象缓存到jvm内存中
        LocalCache.put(Constants.COURSE_ALLCOURSECLASSLIST, eduCourseClassRespList);
        log.info("1.初始化数据【allCourseClassList：{}】 完成", allCourseClassList);
    }
}