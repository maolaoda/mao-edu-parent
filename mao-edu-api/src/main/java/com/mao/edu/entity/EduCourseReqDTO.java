package com.mao.edu.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenyao
 * @date 2023-10-19 10:54
 */
@Data
public class EduCourseReqDTO
{
    @ApiModelProperty("课程名称")
    private String courseName;


    @ApiModelProperty("课程专业ID")
    private Integer subjectId;

    private Integer pageNo;
}
