package com.atguigu.blogxhc.mapper;

import com.atguigu.blogxhc.pojos.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public List<Article> findAllById(Integer cid);

    public Article findById(Integer id);

    public boolean addArticle(Article article);

    public boolean deleteArticle(Integer id);

}
