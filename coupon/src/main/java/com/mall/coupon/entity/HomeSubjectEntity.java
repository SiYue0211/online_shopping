package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * The subject in the home page
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * subject name
     */
    private String name;
    /**
     * subject title
     */
    private String title;
    /**
     * subject sub-title
     */
    private String subTitle;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private String url;
    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private String img;

}
