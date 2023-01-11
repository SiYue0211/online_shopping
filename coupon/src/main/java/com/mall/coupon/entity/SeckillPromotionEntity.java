package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * seckill activities
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_seckill_promotion")
public class SeckillPromotionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private String title;
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
    private Date createTime;
    /**
     *
     */
    private Long userId;

}
