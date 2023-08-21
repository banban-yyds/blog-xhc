package com.atguigu.blogxhc.service.impl;

import com.atguigu.blogxhc.annotation.QueryCache;
import com.atguigu.blogxhc.mapper.ArticleMapper;
import com.atguigu.blogxhc.pojos.Article;
import com.atguigu.blogxhc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceimpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    @QueryCache(keyPrefix = "article:list")
    public List<Article> findAllById(Integer cid) {
        return articleMapper.findAllById(cid);
    }

    @Override
    @QueryCache(keyPrefix = "article:info")
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public boolean addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public boolean deleteArticle(Integer id) {
        return articleMapper.deleteArticle(id);
    }
}
