package com.demo.springboot.springboot_demo.testUserMapper;

import com.demo.springboot.mybatis.entity.User;
import com.demo.springboot.mybatis.mapper.UserMapper;
import com.demo.springboot.mybatis.service.UserService;
import com.demo.springboot.springboot_demo.SpringbootDemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestUserServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
@Test
    public void testVerify(){
//        测试数据
        String userCode="admin";
        String userPassword="1234567";
//        期望
        boolean result = true;
//        获取实际结果
        result=userService.verify(userCode,userPassword);
//        断言
        Assert.assertTrue(result);
    }
    @Test
    public void testregister(){
        User user = new User();
        user.setUsercode("tanzhuo1");
        user.setUsername("谭卓");
        user.setUserpassword("1234567");
        user.setGender(1);
        user.setPhone("12312347123");
        this.userService.register(user);
        user=userMapper.selectByUserCode("tanzhuo1");
        Assert.assertNotNull(user);
    }
    @Test
    public void testSearchAll(){
        List<User> userList = this.userService.searchAll();
        int size = userList.size();
        boolean bool = size==18;
        Assert.assertTrue(bool);
    }
}
