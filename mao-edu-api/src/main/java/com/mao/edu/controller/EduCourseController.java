package com.mao.edu.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.PageUtil;
import com.mao.edu.base.BaseApiController;
import com.mao.edu.base.BaseResponse;
import com.mao.edu.constant.Constants;
import com.mao.edu.core.cache.LocalCache;
import com.mao.edu.entity.EduCourseReqDTO;
import com.mao.edu.entity.EduCourseRespDTO;
import com.mao.edu.service.IEduCourseClassService;
import com.mao.edu.service.IEduCourseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenyao
 * @date 2023-10-19 10:01
 */
@RestController
@RequestMapping("/course")
@ApiOperation(value = "课程列表", notes = "课程分类")
@Slf4j
public class EduCourseController extends BaseApiController
{
    @Autowired
    private IEduCourseClassService iEduCourseClassService;

    @Autowired
    private IEduCourseService iEduCourseService;

    /**
     * 查询所有的课程分类
     *
     * @return
     */
    @GetMapping("/getAllCourseList")
    @ApiOperation(value = "查询所有课程列表", notes = "查询所有课程列表")
    public BaseResponse getAllCourseList()
    {
        List<EduCourseRespDTO> eduCourseRespList = new ArrayList<>();
        eduCourseRespList = LocalCache.get(
            Constants.COURSE_ALLCOURSELIST,
            eduCourseRespList);
        if (CollectionUtils.isEmpty(eduCourseRespList))
        {
            log.error("[从缓存中为查找到eduCourseRespList数据]");
            return setResultError("未查找数据");
        }
        return setResultSuccessData(eduCourseRespList);

    }

    /**
     * 根据条件搜索课程
     *
     * @return
     */
    @PostMapping("/searchCourseList")
    @ApiOperation(value = "根据条件搜索课程", notes = "根据条件搜索课程")
    public BaseResponse searchCourseList(@RequestBody EduCourseReqDTO eduCourseReqDto)
    {
        List<EduCourseRespDTO> eduCourseRespDtoList = iEduCourseService.searchCacheCourseList(eduCourseReqDto);
        if (eduCourseRespDtoList == null)
        {
            log.error("[根据条件：{}，未查找到数据]", eduCourseReqDto);
            return setResultError("未查找到数据");
        }
        Integer totalSize = eduCourseRespDtoList.size();
        Integer totalPage = PageUtil.totalPage(totalSize, Constants.DEFAULT_PAGE_SIZE);
        int pageNo = eduCourseReqDto.getPageNo();
        if (!(pageNo <= totalPage))
        {
            log.error("[pageNo参数传递错误] {}", pageNo);
            return setResultError("[pageNo参数传递错误]");
        }
        // 分页，索引小于等于总页数，才返回列表.
        List<EduCourseRespDTO> listPageEduCourses = CollUtil.page(pageNo - 1, Constants.DEFAULT_PAGE_SIZE,
            eduCourseRespDtoList);
        // 返回最终数据
        HashMap result = new HashMap();
        result.put("pageNo", pageNo); //当前页面
        result.put("pageSize", Constants.DEFAULT_PAGE_SIZE); // 每页条数
        result.put("total", totalSize); // 总记录数
        result.put("totalPage", totalPage); // 总页数
        result.put("listPageEduCourses", listPageEduCourses); // 分页后数据
        return setResultSuccessData(result);
    }
}
