package com.demo.springboot.springboot_demo.testUserMapper;

import com.demo.springboot.mybatis.entity.User;
import com.demo.springboot.mybatis.mapper.UserMapper;
import com.demo.springboot.springboot_demo.SpringbootDemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectByPrimaryKey(){
//        准备测试数据
        long id=1;
//        准备期望值
        String userCode="admin";
        String userName="系统管理员";
//        获取实际值
        User user = userMapper.selectByPrimaryKey(id);
        String Usercode=user.getUsercode();
        String Username=user.getUsername();
        Assert.assertEquals(userCode,Usercode);
        Assert.assertEquals(userName,Username);
    }

}
