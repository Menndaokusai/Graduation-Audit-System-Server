package com.example.demo.controller;


import com.example.demo.utils.Message;
import com.example.demo.utils.PageList;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PassToken;
import com.example.demo.utils.StatusType;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PassToken
    @PostMapping("/login")
    public Object login(@RequestBody User user){

        User uuser = userService.select(user.getUsername());

        if(uuser!=null){
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if(uuser.getPassword().equals(md5Password)){
                String token = TokenUtils.buildJWT(uuser.getUsername());

                return new Message(StatusType.SUCCESS_STATUS,"登录成功",token);
            }
            else{
                return new Message(StatusType.ERROR_STATUS,"用户名或密码不正确");
            }
        }

        return new Message(StatusType.ERROR_STATUS,"用户名或密码不正确");

    }

    @GetMapping("/list")
    public Object fetchList(String username,int page,int limit){
        int start = (page-1)*limit;
        List<Object> lists;
        if(username==null||username.equals("")){
            lists = Collections.singletonList(userService.selectAll(start,limit));
        }
        else{
            lists = Collections.singletonList(userService.select(username));
        }


        return new PageList(StatusType.SUCCESS_STATUS,lists);
    }

    @GetMapping("/info")
    public Object getInfo(String username){
        List<Object> lists = Collections.singletonList(userService.select(username));
        return new Message(StatusType.SUCCESS_STATUS,"获取用户信息成功",lists);
    }

    @PassToken
    @RequestMapping("/logout")
    public Object logout(){
        return new Message(StatusType.SUCCESS_STATUS,"登出成功");
    }


    @PostMapping("/create")
    public Object createUser(@RequestBody User user){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
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
    public Object updateUser(@RequestBody User user){
        try {
            if(!user.getPassword().equals("")){
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
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

    @PostMapping("/delete")
    public Object deleteUser(@RequestBody User user){

        try {
            int result = userService.delete(user.getUsername());
            if(result>0){
                return new Message(StatusType.SUCCESS_STATUS,"删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Message(StatusType.ERROR_STATUS,"删除失败");
    }

}
