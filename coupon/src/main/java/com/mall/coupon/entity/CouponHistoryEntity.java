package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_coupon_history")
public class CouponHistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long couponId;
    /**
     *
     */
    private Long memberId;
    /**
     *
     */
    private String memberNickName;
    /**
     * 0: Backstage gift; 1: Pick up by users
     */
    private Integer getType;
    /**
     *
     */
    private Date createTime;
    /**
     * 0: Unused 1: Used 2: Expired
     */
    private Integer useType;
    /**
     *
     */
    private Date useTime;
    /**
     *
     */
    private Long orderId;
    /**
     *
     */
    private Long orderSn;

}
