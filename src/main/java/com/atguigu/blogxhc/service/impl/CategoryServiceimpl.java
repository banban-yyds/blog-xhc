package com.atguigu.blogxhc.service.impl;

import com.atguigu.blogxhc.annotation.QueryCache;
import com.atguigu.blogxhc.mapper.CategoryMapper;
import com.atguigu.blogxhc.pojos.Category;
import com.atguigu.blogxhc.result.PageResult;
import com.atguigu.blogxhc.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    // 添加redis缓存机制
    @Override
    @QueryCache(keyPrefix = "category:list") // 给通知方法传入前缀，实现通知方法复用
    public List<Category> findAll() {
//        使用redis缓存
//        List<Category> categoryList =(List<Category>) redisTemplate.opsForValue().get("category:list");
//        if (categoryList == null || categoryList.size() <=0){
//            log.info("从mysql中获取数据");
//            categoryList = categoryMapper.findAll();
//            redisTemplate.opsForValue().set("category:list",categoryList);
//        }
//        return categoryList;
        return categoryMapper.findAll();
    }

    // 分页查询
    @Override
    @QueryCache(keyPrefix = "category:page")
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
