package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.StatusType;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.List;

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
                return new Message(StatusType.SUCCESS_STATUS,"登录成功",token);
            }
            else{
                return new Message(StatusType.ERROR_STATUS,"用户名或密码不正确");
            }
        }

        return new Message(StatusType.ERROR_STATUS,"用户名或密码不正确");

    }

    @RequestMapping("/info")
    public Object getInfo(String account){
        List<Object> users = Collections.singletonList(userService.select(account));
        return new Message(StatusType.SUCCESS_STATUS,"获取用户信息成功",users);
    }

    @PassToken
    @RequestMapping("/logout")
    public Object logout(){
        return new Message(StatusType.SUCCESS_STATUS,"登出成功");
    }

    @GetMapping("/list")
    public Object fetchList(){
        List<Object> users = Collections.singletonList(userService.selectAll());
        return new Message(StatusType.SUCCESS_STATUS,"获取用户列表成功",users);
    }

    @PostMapping("/create")
    public Object createUser(String account,String password,String roleId){
        User user = new User();
        user.setAccount(account);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setRoleId(roleId);
        try{
            int result = userService.insert(user);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"创建用户成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"创建用户失败");
    }

    @PostMapping("/update")
    public Object updateUser(String account,String password,String roleId){
        User user = new User();
        user.setAccount(account);
        user.setRoleId(roleId);
        try {
            if(!password.equals("")){
                user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
                int result = userService.update(user);
                if(result>0){
                    return new Message(StatusType.SUCCESS_STATUS,"更新用户信息成功");
                }
                return new Message(StatusType.ERROR_STATUS,"更新用户信息失败");
            }
            int result = userService.updateRole(user);
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"更新用户角色成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(StatusType.ERROR_STATUS,"更新用户角色失败");
    }

}
