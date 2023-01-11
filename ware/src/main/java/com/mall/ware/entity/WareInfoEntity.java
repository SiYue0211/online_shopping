package com.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * warehouse information
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:34:52
 */
@Data
@TableName("wms_ware_info")
public class WareInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * warehouse name
     */
    private String name;
    /**
     * warehouse address
     */
    private String address;
    /**
     *
     */
    private String areacode;

}
