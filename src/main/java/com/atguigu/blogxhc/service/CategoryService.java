package com.atguigu.blogxhc.service;

import com.atguigu.blogxhc.pojos.Category;
import com.atguigu.blogxhc.result.PageResult;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public PageResult<Category> queryListPage(Integer pageNum,Integer pageSize,Category category);

    public boolean addCategory(Category category);

    public boolean deleteCategory(Integer cid);

    public boolean updateCategort(Category category);

}
