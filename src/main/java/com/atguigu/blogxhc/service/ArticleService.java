package com.atguigu.blogxhc.service;

import com.atguigu.blogxhc.pojos.Article;


import java.util.List;

public interface ArticleService {
    public List<Article> findAllById(Integer cid);

    public Article findById(Integer id);

    public boolean addArticle(Article article);

    public boolean deleteArticle(Integer id);
}
