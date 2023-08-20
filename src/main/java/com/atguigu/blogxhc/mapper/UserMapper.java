package com.atguigu.blogxhc.mapper;

import com.atguigu.blogxhc.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {
    public User login(String username);

    public User findById(Integer uid);

    public boolean updateUserInfo(User user);
}
