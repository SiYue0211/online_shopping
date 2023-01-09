package com.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.product.entity.BrandEntity;
import com.mall.product.service.BrandService;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("Apple Pro");
//        brandService.updateById(brandEntity);
//        System.out.println("Update successfully");

//        brandEntity.setName("Apple");
//        brandService.save(brandEntity);
//        System.out.println("Save successfully!");

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach((item) -> {
            System.out.println(item);
        });
    }

}
