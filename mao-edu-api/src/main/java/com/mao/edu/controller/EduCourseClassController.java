package com.mao.edu.controller;

import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import com.mao.edu.constant.Constants;
import com.mao.edu.core.cache.LocalCache;
import com.mao.edu.entity.EduCourseClass;
import com.mao.edu.service.IEduCourseClassService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mao
 * @since 2023-10-18
 */
@Slf4j
@RestController
@RequestMapping("/course")
@ApiOperation(value = "课程分类", notes = "课程分类")
public class EduCourseClassController extends BaseApiController
{
    @Autowired
    private IEduCourseClassService iEduCourseClassService;

    /**
     * 查询所有的课程分类
     *
     * @return
     */
    @GetMapping("/getAllCourseClass")
    @ApiOperation(value = "查询所有课程分类", notes = "查询所有课程分类")
    public BaseResponse getAllCourseClass() {
//        List<EduCourseClass> allCourseClass = iEduCourseClassService.getAllCourseClass();
        List<EduCourseClass> allCourseClass = new ArrayList<>();
        allCourseClass = LocalCache.get(Constants.COURSE_ALLCOURSECLASSLIST,
            allCourseClass);
        if (CollectionUtils.isEmpty(allCourseClass)) {
            log.error("[从集合中为查找到所有的课程分类数据]");
            return setResultError();
        }
        return setResultSuccessData(allCourseClass);
    }
}
