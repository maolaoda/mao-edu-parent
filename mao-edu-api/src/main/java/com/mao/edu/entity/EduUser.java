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
 * @since 2023-10-20
 */
@TableName("edu_user")
@ApiModel(value = "EduUser对象", description = "")
public class EduUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学员ID")
      @TableId(value = "USER_ID", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码盐值")
    private String userSalt;

    @ApiModelProperty("显示名 （昵称）")
    private String showName;

    @ApiModelProperty("性别  1男  2女")
    private Boolean sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否可用 1正常  2冻结")
    private Boolean isAvalible;

    @ApiModelProperty("用户头像")
    private String picImg;

    @ApiModelProperty("个人中心用户背景图片")
    private String bannerUrl;

    private String qqOpenid;

    @ApiModelProperty("会员卡ids")
    private String memberCardIds;

    private String wxOpenId;

    private String qq;

    private LocalDateTime updateTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsAvalible() {
        return isAvalible;
    }

    public void setIsAvalible(Boolean isAvalible) {
        this.isAvalible = isAvalible;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getMemberCardIds() {
        return memberCardIds;
    }

    public void setMemberCardIds(String memberCardIds) {
        this.memberCardIds = memberCardIds;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "EduUser{" +
        "userId=" + userId +
        ", password=" + password +
        ", userName=" + userName +
        ", userSalt=" + userSalt +
        ", showName=" + showName +
        ", sex=" + sex +
        ", age=" + age +
        ", createTime=" + createTime +
        ", isAvalible=" + isAvalible +
        ", picImg=" + picImg +
        ", bannerUrl=" + bannerUrl +
        ", qqOpenid=" + qqOpenid +
        ", memberCardIds=" + memberCardIds +
        ", wxOpenId=" + wxOpenId +
        ", qq=" + qq +
        ", updateTime=" + updateTime +
        "}";
    }
}
