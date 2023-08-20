package com.atguigu.blogxhc.service;

import com.atguigu.blogxhc.exception.UserNameNotFindException;
import com.atguigu.blogxhc.exception.UserPasswordNotFindException;
import com.atguigu.blogxhc.pojos.User;

import java.util.List;

public interface UserService {
    public User login(User user);

    public User findById(Integer uid);

    public boolean updateUserInfo(User user);

}
