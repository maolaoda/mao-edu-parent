package com.mao.edu.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenyao
 * @date 2023-10-18 17:29
 */
@Data
public class EduCourseClassRespDTO implements Serializable

{

    private Integer id;
    private String className;
    private String url;
}
