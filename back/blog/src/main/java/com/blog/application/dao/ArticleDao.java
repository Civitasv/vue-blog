package com.blog.application.dao;

import com.blog.application.model.Article;
import com.blog.application.model.Label;

import java.util.List;

public interface ArticleDao {
    // 得到所有的文章
    List<Article> getAllArticles();

    // 根据id得到文章
    Article getArticleByID(int articleID);

    // 添加文章
    int insertArticle(Article article);


    // 根据ID删除文章
    int deleteArticleByTD(int articleID);

    // 根据ID更新文章
    int updateArticleByID(Article article);

    // 访问量++
    int addReadNum();
}
