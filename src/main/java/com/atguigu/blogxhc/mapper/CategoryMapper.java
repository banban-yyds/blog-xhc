package com.atguigu.blogxhc.mapper;

import com.atguigu.blogxhc.pojos.Category;
import com.atguigu.blogxhc.result.PageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<Category> findAll();

    public List<Category> queryListPage(String cname);

    public boolean addCategory(Category category);

    public boolean deleteCategory(Integer cid);

    public boolean updateCategory(Category category);
}
