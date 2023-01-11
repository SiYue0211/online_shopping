package com.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:34:52
 */
@Data
@TableName("wms_ware_order_task")
public class WareOrderTaskEntity implements Serializable {
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
     * order_sn
     */
    private String orderSn;
    /**
     * receiver name
     */
    private String consignee;
    /**
     * receiver phone number
     */
    private String consigneeTel;
    /**
     * receiver address
     */
    private String deliveryAddress;
    /**
     *
     */
    private String orderComment;
    /**
     * 1-pay-online 2-pay after delivery
     */
    private Integer paymentWay;
    /**
     *
     */
    private Integer taskStatus;
    /**
     * order description
     */
    private String orderBody;
    /**
     * track number
     */
    private String trackingNo;
    /**
     * create_time
     */
    private Date createTime;
    /**
     * warehouse id
     */
    private Long wareId;
    /**
     *
     */
    private String taskComment;

}
