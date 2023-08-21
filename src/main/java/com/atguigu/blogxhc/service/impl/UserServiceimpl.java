package com.atguigu.blogxhc.service.impl;

import com.atguigu.blogxhc.annotation.QueryCache;
import com.atguigu.blogxhc.exception.UserNameNotFindException;
import com.atguigu.blogxhc.exception.UserPasswordNotFindException;
import com.atguigu.blogxhc.mapper.UserMapper;
import com.atguigu.blogxhc.pojos.User;
import com.atguigu.blogxhc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User loginUser = userMapper.login(user.getUsername());

        if (loginUser.getUsername() == null){
            throw new UserNameNotFindException();
        } else if (!user.getPassword().equals(loginUser.getPassword() )|| user.getPassword() == "") {
            throw new UserPasswordNotFindException();
        }
        loginUser.setPassword(null);
        return loginUser;
    }

    @Override
    @QueryCache(keyPrefix = "user:info")
    public User findById(Integer uid) {
        return userMapper.findById(uid);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }


}
