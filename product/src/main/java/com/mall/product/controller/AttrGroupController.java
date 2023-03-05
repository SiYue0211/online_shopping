package com.mall.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.mall.product.entity.AttrAttrgroupRelationEntity;
import com.mall.product.entity.AttrEntity;
import com.mall.product.service.AttrAttrgroupRelationService;
import com.mall.product.service.AttrService;
import com.mall.product.service.CategoryService;
import com.mall.product.vo.AttrGroupRelationVo;
import com.mall.product.vo.AttrGroupWithAttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mall.product.entity.AttrGroupEntity;
import com.mall.product.service.AttrGroupService;
import com.mall.common.utils.PageUtils;
import com.mall.common.utils.R;


/**
 * Attribute group
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService attrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list/{catalogId}")
//    @RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable Long catalogId) {
        PageUtils page = attrGroupService.queryPage(params, catalogId);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catalogId = attrGroup.getCatalogId();
        Long[] catalogPath = categoryService.findCatalogPath(catalogId);
        attrGroup.setCatalogPath(catalogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    /**
     *
     * API example: /product/attrgroup/attr/relation/delete
     */
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] vos) {
        attrService.deleteRelation(vos);

        return R.ok();
    }

    /***
     * Build the relation between different attributes
     * example: // api/product/attrgroup/1/attr/relation?t=1675878470391
     * @return
     */
    @RequestMapping("/{groupId}/attr/relation")
    public R attrRelation(@PathVariable Long groupId) {
        ArrayList<AttrEntity> entityList = attrService.getRelationAttr(groupId);

        return R.ok().put("data", entityList.toArray());
    }

    /**
     *
     * API example: /product/attrgroup/{attrgroupId}/noattr/relation
     */
    @RequestMapping("/{groupId}/noattr/relation")
    public R attrNoRelation(@PathVariable Long groupId,
                            @RequestParam Map<String, Object> params) {
        PageUtils page = attrService.getNoRelationAttr(params, groupId);

        return R.ok().put("page", page);
    }

    /**
     *
     * API example: /product/attrgroup/attr/relation
     */
    @RequestMapping("/attr/relation")
    public R addAttrRelation(@RequestBody ArrayList<AttrAttrgroupRelationEntity> relationEntity) {
        attrgroupRelationService.saveBatch(relationEntity);

        return R.ok();
    }

    /**
     * API example: /product/attrgroup/{catalogId}/withattr
     */
    @RequestMapping("/{catalogId}/withattr")
    public R getAttrgroupWithAttr(@PathVariable Long catalogId) {
        List<AttrGroupWithAttrVo> vos = attrGroupService.getAttrGroupWithAttrsByCatalogId(catalogId);
        return R.ok().put("data", vos);
    }

}
