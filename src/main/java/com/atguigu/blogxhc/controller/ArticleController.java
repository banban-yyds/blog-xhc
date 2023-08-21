package com.atguigu.blogxhc.controller;

import com.atguigu.blogxhc.annotation.QueryCache;
import com.atguigu.blogxhc.constant.SessionConstant;
import com.atguigu.blogxhc.pojos.Article;
import com.atguigu.blogxhc.pojos.User;
import com.atguigu.blogxhc.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping("/queryList")
    public List<Article> findAllById(@RequestBody Article article){
        return articleService.findAllById(article.getCid());
    }

    @GetMapping("/getArticle/{id}")
    public Article findById(@PathVariable("id") Integer id){
        return articleService.findById(id);
    }

    @PostMapping("/addArticle")
    public boolean addArticle(@RequestBody Article article, HttpSession session){
        User user = (User) session.getAttribute(SessionConstant.LOGIN_SESSION_KEY);
        if (user != null){
            article.setUid(user.getUid());
        }
        return articleService.addArticle(article);
    }
    @DeleteMapping("/deleteArticle/{id}")
    public boolean deleteArticle(@PathVariable("id") Integer id){
        return articleService.deleteArticle(id);
    }
}
