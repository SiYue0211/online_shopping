package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Coupon information
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_coupon")
public class CouponEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 0: For all kind of user; 1: For members; 2: For shopping users; 3. For new register users
     */
    private Integer couponType;
    /**
     *
     */
    private String couponImg;
    /**
     *
     */
    private String couponName;
    /**
     * Coupon number
     */
    private Integer num;
    /**
     * Coupon Amount
     */
    private BigDecimal amount;
    /**
     * The limit coupon number for each people
     */
    private Integer perLimit;
    /**
     * The min threshold to use coupon
     */
    private BigDecimal minPoint;
    /**
     *
     */
    private Date startTime;
    /**
     *
     */
    private Date endTime;
    /**
     * 0->All 1->Some specified types 2->Some specified items]
     */
    private Integer useType;
    /**
     *
     */
    private String note;
    /**
     *
     */
    private Integer publishCount;
    /**
     *
     */
    private Integer useCount;
    /**
     * The count of coupon that has been got
     */
    private Integer receiveCount;
    /**
     * The start time to pick up the coupons
     */
    private Date enableStartTime;
    /**
     * Then end time to pick up the coupons
     */
    private Date enableEndTime;
    /**
     * coupon code
     */
    private String code;
    /**
     * The member level that can pick up the coupons 0->Any one, Others->specified level
     */
    private Integer memberLevel;
    /**
     * 0: false, 1: true
     */
    private Integer publish;

}
