package com.mall.ware;

import com.mall.ware.entity.WareInfoEntity;
import com.mall.ware.service.WareInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WareApplicationTests {
    @Autowired
    WareInfoService wareInfoService;

    @Test
    public void contextLoads() {
        WareInfoEntity wareInfoEntity = new WareInfoEntity();
        wareInfoEntity.setName("Kettle");
        wareInfoService.save(wareInfoEntity);
        System.out.println("Success!!!");
    }

}
