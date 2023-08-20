package com.atguigu.blogxhc.controller;

import com.atguigu.blogxhc.constant.SessionConstant;
import com.atguigu.blogxhc.pojos.User;
import com.atguigu.blogxhc.service.UserService;
import com.atguigu.blogxhc.vos.UserVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public UserVo login(@RequestBody User user, HttpSession session){
        User loginInfo = userService.login(user);
        session.setAttribute(SessionConstant.LOGIN_SESSION_KEY, loginInfo);
        UserVo userVo = new UserVo(loginInfo.getUid(), loginInfo.getUsername());
        return userVo;

    }
    @GetMapping("/getUser/{uid}")
    public User findById(@PathVariable("uid") Integer uid){
        return userService.findById(uid);
    }
    @PutMapping("/updateUser")
    public boolean updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

}
