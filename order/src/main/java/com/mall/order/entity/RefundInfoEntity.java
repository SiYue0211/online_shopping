package com.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:49
 */
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long orderReturnId;
    /**
     *
     */
    private BigDecimal refund;
    /**
     *
     */
    private String refundSn;
    /**
     *
     */
    private Integer refundStatus;
    /**
     *
     */
    private Integer refundChannel;
    /**
     *
     */
    private String refundContent;

}
