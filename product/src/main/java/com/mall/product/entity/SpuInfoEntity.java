package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@Data
@TableName("pms_spu_info")
public class SpuInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * item id
     */
    @TableId
    private Long id;
    /**
     * item name
     */
    private String spuName;
    /**
     * item description
     */
    private String spuDescription;
    /**
     *
     */
    private Long catalogId;
    /**
     *
     */
    private Long brandId;
    /**
     *
     */
    private BigDecimal weight;
    /**
     * 1: For sale 0: Not for sale
     */
    private Integer publishStatus;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

}
