package com.demo.springboot.mybatis.controller;

import com.demo.springboot.mybatis.entity.User;
import com.demo.springboot.mybatis.service.UserService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Usercontroller {
    @Autowired
    private UserService userService;
//    显示登录页面的请求方法
    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
//    处理登陆验证的方法
    @PostMapping("/login")
    public String login(String userCode, String userPassword, Model model){
        String result = "redirect:/userList";
        boolean bool =false;
        String msg =null;
        try{
            bool=this.userService.verify(userCode,userPassword);
            if(!bool){
                msg="登陆失败:密码不匹配";
            }
        }catch(Exception e){
            msg = "登陆失败:"+e.getMessage();
        }
        if(!bool){
            model.addAttribute("msg",msg);
            result = "redirect:/loginPage";
        }
        return result;
    }
//    注册页面的方法
    @GetMapping("/registerPage")
    public String registerPage(){
        return "register";
    }
//    处理注册功能的方法
    @PostMapping("/register")
    public String register(User user,Model model){
        String result = "redirect:loginPage";
        String msg = null;
        try {
            this.userService.register(user);
        }catch(Exception e){
            msg="注册失败:"+e.getMessage();
            model.addAttribute("msg",msg);
            result ="redirect:/registerPage";
        }
        return result;
    }
//    显示所有用户列表的方法
    @GetMapping("/userList")
    public String userList(Model model){
        List<User> userList = this.userService.searchAll();
        model.addAttribute("userList",userList);
        return "userList";
    }
}
