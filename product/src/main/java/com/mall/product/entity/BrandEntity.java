package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.mall.common.valid.AddGroup;
import com.mall.common.valid.ListValue;
import com.mall.common.valid.UpdateGroup;
import com.mall.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

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
    @NotNull(message = "The brandId must be un-null when updating the data.", groups = {UpdateGroup.class})
    @Null(message = "The brandId must be empty when adding the data.", groups = {AddGroup.class})
    private Long brandId;
    /**
     * brand name
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * logo url
     */
    @NotNull(groups = {UpdateGroup.class})
    @URL(groups = {AddGroup.class, UpdateGroup.class})
    private String logo;
    /**
     * description
     */
    private String descript;
    /**
     * 0: invisible, 1:visible
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class, UpdateStatusGroup.class})
    @ListValue(vals={0, 1}, groups = {AddGroup.class, UpdateGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;
    /**
     *
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Pattern(regexp = "/[a-zA-Z]$/", message = "The firstLetter must be a letter from a-z/A-Z")
    private String firstLetter;
    /**
     *
     */
    @NotNull(groups = {AddGroup.class, UpdateGroup.class})
    @Min(value = 0, message = "Sort must be larger than 0.")
    private Integer sort;

}
