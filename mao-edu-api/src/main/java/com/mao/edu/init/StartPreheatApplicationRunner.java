package com.mao.edu.init;

import cn.hutool.core.bean.BeanUtil;
import com.mao.edu.constant.Constants;
import com.mao.edu.entity.EduCourseClass;
import com.mao.edu.entity.EduCourseClassRespDTO;
import com.mao.edu.service.IEduCourseClassService;
import com.mao.edu.service.IStartPreheatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenyao
 * @date 2023-10-18 17:19
 */
@Component
@Slf4j
public class StartPreheatApplicationRunner implements ApplicationRunner
{
    @Autowired
    private IStartPreheatService iStartPreheatService;
    @Override
    public void run(ApplicationArguments args)
        throws Exception
    {
        log.info("[开始预热db中数据到缓存中..]");
        iStartPreheatService.initData();
    }
}
