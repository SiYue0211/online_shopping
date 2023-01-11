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
@TableName("wms_purchase_detail")
public class PurchaseDetailEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long purchaseId;
    /**
     * item id
     */
    private Long skuId;
    /**
     * item number
     */
    private Integer skuNum;
    /**
     * item amount
     */
    private BigDecimal skuPrice;
    /**
     * warehouse id
     */
    private Long wareId;
    /**
     * 0-created; 1-dispensed; 2-doing; 3-done; 4-failure
     */
    private Integer status;

}
