package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * The advertisement in the home page
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_home_adv")
public class HomeAdvEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String pic;
    /**
     *
     */
    private Date startTime;
    /**
     *
     */
    private Date endTime;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Integer clickCount;
    /**
     * The advertisement url
     */
    private String url;
    /**
     *
     */
    private String note;
    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private Long publisherId;
    /**
     *
     */
    private Long authId;

}
