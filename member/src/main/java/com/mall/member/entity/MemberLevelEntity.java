package com.mall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * member level
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:22:34
 */
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private Integer growthPoint;
    /**
     *
     */
    private Integer defaultStatus;
    /**
     * The standard of free postage
     */
    private BigDecimal freeFreightPoint;
    /**
     * growth points from comment item
     */
    private Integer commentGrowthPoint;
    /**
     * Free postage right
     */
    private Integer priviledgeFreeFreight;
    /**
     * Member price right
     */
    private Integer priviledgeMemberPrice;
    /**
     * Birthday price right
     */
    private Integer priviledgeBirthday;
    /**
     *
     */
    private String note;

}
