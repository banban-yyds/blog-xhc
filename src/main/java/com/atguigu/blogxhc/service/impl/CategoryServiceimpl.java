package com.atguigu.blogxhc.service.impl;

import com.atguigu.blogxhc.mapper.CategoryMapper;
import com.atguigu.blogxhc.pojos.Category;
import com.atguigu.blogxhc.result.PageResult;
import com.atguigu.blogxhc.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public PageResult<Category> queryListPage(Integer pageNum, Integer pageSize, Category category) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Category> pageInfo = new PageInfo(categoryMapper.queryListPage(category.getCname()),pageSize);
        return new PageResult<Category>(pageInfo.getList(),pageInfo.getTotal());
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public boolean deleteCategory(Integer cid) {
        return categoryMapper.deleteCategory(cid);
    }

    @Override
    public boolean updateCategort(Category category) {
        return categoryMapper.updateCategory(category);
    }
}
