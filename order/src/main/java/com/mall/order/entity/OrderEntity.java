package com.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Order
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:50
 */
@Data
@TableName("oms_order")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * order number
     */
    private String orderSn;
    /**
     *
     */
    private Long couponId;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private String memberUsername;
    /**
     * Total payment
     */
    private BigDecimal totalAmount;
    /**
     * The payment we need to pay
     */
    private BigDecimal payAmount;
    /**
     * postage
     */
    private BigDecimal freightAmount;
    /**
     * promotion
     */
    private BigDecimal promotionAmount;
    /**
     *
     */
    private BigDecimal integrationAmount;
    /**
     *
     */
    private BigDecimal couponAmount;
    /**
     *
     */
    private BigDecimal discountAmount;
    /**
     * 1 alipay 2 wechat pay 3 China Unionpay 4 payon delivery
     */
    private Integer payType;
    /**
     * 0: PC 1: APP
     */
    private Integer sourceType;
    /**
     * 0: pending 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled
     */
    private Integer status;
    /**
     *
     */
    private String deliveryCompany;
    /**
     *
     */
    private String deliverySn;
    /**
     *
     */
    private Integer autoConfirmDay;
    /**
     *
     */
    private Integer integration;
    /**
     *
     */
    private Integer growth;
    /**
     * invoice type: no invoice 1: e-invoice 2: paper-invoice
     */
    private Integer billType;
    /**
     * invoice header
     */
    private String billHeader;
    /**
     * invoice content
     */
    private String billContent;
    /**
     * invoice receiver phone
     */
    private String billReceiverPhone;
    /**
     * invoice receiver email
     */
    private String billReceiverEmail;
    /**
     *
     */
    private String receiverName;
    /**
     *
     */
    private String receiverPhone;
    /**
     *
     */
    private String receiverPostCode;
    /**
     *
     */
    private String receiverProvince;
    /**
     *
     */
    private String receiverCity;
    /**
     *
     */
    private String receiverRegion;
    /**
     *
     */
    private String receiverDetailAddress;
    /**
     *
     */
    private String note;
    /**
     * 0: unconfirmed 1: confirmed
     */
    private Integer confirmStatus;
    /**
     * 0: undeleted 1:deleted
     */
    private Integer deleteStatus;
    /**
     *
     */
    private Integer useIntegration;
    /**
     *
     */
    private Date paymentTime;
    /**
     *
     */
    private Date deliveryTime;
    /**
     *
     */
    private Date receiveTime;
    /**
     *
     */
    private Date commentTime;
    /**
     *
     */
    private Date modifyTime;

}
