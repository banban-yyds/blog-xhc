package com.atguigu.blogxhc.controller;

import com.atguigu.blogxhc.pojos.Category;
import com.atguigu.blogxhc.result.PageResult;
import com.atguigu.blogxhc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/queryList")
    public List<Category> findAll(){
        return  categoryService.findAll();
    }

    @PostMapping("/queryListPage/{pageNum}/{pageSize}")
    public PageResult<Category> queryListCategory(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody Category category){
        return categoryService.queryListPage(pageNum, pageSize,category);
    }

    @PostMapping("/addCategory")
    public boolean addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @DeleteMapping("/deleteCategory/{cid}")
    public boolean deleteCategory(@PathVariable("cid") Integer cid){
        return categoryService.deleteCategory(cid);
    }
    @PutMapping("/updateCategory")
    public boolean updateCategory(@RequestBody Category category){
        return categoryService.updateCategort(category);
    }

}
