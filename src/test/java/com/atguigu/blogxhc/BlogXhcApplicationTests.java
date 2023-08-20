package com.atguigu.blogxhc;

import com.atguigu.blogxhc.mapper.CategoryMapper;
import com.atguigu.blogxhc.mapper.UserMapper;
import com.atguigu.blogxhc.pojos.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogXhcApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        System.out.println(categoryMapper.findAll());
    }
    @Test
    public void test02(){
        User user = new User();
        user.setUsername("lucy");
        user.setPassword("123456");
        System.out.println(userMapper.login("lucy"));

    }
}
