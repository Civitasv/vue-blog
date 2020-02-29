package com.blog.application.service.impl;

import com.blog.application.dao.ArticleDao;
import com.blog.application.model.Article;
import com.blog.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public Article getArticleByID(int articleID) {
        return articleDao.getArticleByID(articleID);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public int deleteArticleByTD(int articleID) {
        return articleDao.deleteArticleByTD(articleID);
    }

    @Override
    public int updateArticleByID(int articleID, Article article) {
        return articleDao.updateArticleByID(articleID,article);
    }
}
