package com.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:34:52
 */
@Data
@TableName("wms_purchase")
public class PurchaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * order id
     */
    @TableId
    private Long id;
    /**
     * Buyer id
     */
    private Long assigneeId;
    /**
     * Buyer name
     */
    private String assigneeName;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private Integer priority;
    /**
     *
     */
    private Integer status;
    /**
     * warehouse id
     */
    private Long wareId;
    /**
     * amount
     */
    private BigDecimal amount;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

}
