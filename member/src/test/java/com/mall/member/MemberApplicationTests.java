package com.mall.member;

import com.mall.member.entity.MemberLevelEntity;
import com.mall.member.service.MemberLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberApplicationTests {
    @Autowired
    MemberLevelService memberLevelService;

    @Test
    public void contextLoads() {
        MemberLevelEntity memberLevelEntity = new MemberLevelEntity();
        memberLevelEntity.setName("Golden King");
        memberLevelService.save(memberLevelEntity);
        System.out.println("Success!!!");
    }

}
