package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Brand
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * brand id
     */
    @TableId
    private Long brandId;
    /**
     * brand name
     */
    private String name;
    /**
     * logo url
     */
    private String logo;
    /**
     * description
     */
    private String descript;
    /**
     * 0: invisible, 1:visible
     */
    private Integer showStatus;
    /**
     *
     */
    private String firstLetter;
    /**
     *
     */
    private Integer sort;

}
