package com.mao.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author mao
 * @since 2023-10-18
 */
@TableName("edu_course_class")
@ApiModel(value = "EduCourseClass对象", description = "")
public class EduCourseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("该表是为class 分类表")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String className;

    private Integer classParentId;

    private String url;

    private LocalDateTime createTime;

    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassParentId() {
        return classParentId;
    }

    public void setClassParentId(Integer classParentId) {
        this.classParentId = classParentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "EduCourseClass{" +
        "id=" + id +
        ", className=" + className +
        ", classParentId=" + classParentId +
        ", url=" + url +
        ", createTime=" + createTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
