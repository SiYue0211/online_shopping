package com.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Order return application
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:49
 */
@Data
@TableName("oms_order_return_apply")
public class OrderReturnApplyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * order_id
     */
    private Long orderId;
    /**
     *
     */
    private Long skuId;
    /**
     *
     */
    private String orderSn;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private String memberUsername;
    /**
     *
     */
    private BigDecimal returnAmount;
    /**
     *
     */
    private String returnName;
    /**
     *
     */
    private String returnPhone;
    /**
     * 0: pending 1: in the return 2: finished 3: declined
     */
    private Integer status;
    /**
     *
     */
    private Date handleTime;
    /**
     *
     */
    private String skuImg;
    /**
     *
     */
    private String skuName;
    /**
     *
     */
    private String skuBrand;
    /**
     *
     */
    private String skuAttrsVals;
    /**
     *
     */
    private Integer skuCount;
    /**
     *
     */
    private BigDecimal skuPrice;
    /**
     *
     */
    private BigDecimal skuRealPrice;
    /**
     *
     */
    private String reason;
    /**
     *
     */
    private String description;
    /**
     *
     */
    private String descPics;
    /**
     *
     */
    private String handleNote;
    /**
     *
     */
    private String handleMan;
    /**
     *
     */
    private String receiveMan;
    /**
     *
     */
    private Date receiveTime;
    /**
     *
     */
    private String receiveNote;
    /**
     *
     */
    private String receivePhone;
    /**
     *
     */
    private String companyAddress;

}
