package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PassToken
    @PostMapping("/login")
    public Object login(String account, String password){

        User user = userService.select(account);

        if(user!=null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(user.getPassword().equals(md5Password)){
                String token = TokenUtils.buildJWT(account);
                return new Message(200,"登录成功",token);
            }
            else{
                return new Message(404,"用户名或密码不正确");
            }
        }

        return new Message(404,"用户名或密码不正确");

    }

    @RequestMapping("/info")
    public Object getInfo(String account){
        User user = userService.select(account);
        return new Message(200,"获取用户信息成功",user);
    }

    @PassToken
    @RequestMapping("/logout")
    public Object logout(){
        return new Message(200,"登出成功");
    }


}
