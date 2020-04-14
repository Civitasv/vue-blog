package com.blog.application.service.impl;

import com.blog.application.dao.Article2LabelDao;
import com.blog.application.dao.ArticleDao;
import com.blog.application.dao.LabelDao;
import com.blog.application.model.Article;
import com.blog.application.model.Article2Label;
import com.blog.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private Article2LabelDao article2LabelDao;

    @Override
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public Article getArticleByID(int articleID) {
        return articleDao.getArticleByID(articleID);
    }

    @Override
    public int insertArticle(Article article, String[] labels) {
        articleDao.insertArticle(article);
        List<Article2Label> labels1 = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == "")
                continue;
            if (null == labelDao.getLabelByContent(labels[i])) {
                labelDao.insertLabel(labels[i]);
            }
            labels1.add(new Article2Label(article.getArticleID(), labels[i]));
        }
        if (labels1.size() != 0) {
            res = article2LabelDao.insert(labels1);
        }
        return res;
    }

    @Override
    public int deleteArticleByTD(int articleID) {
        return articleDao.deleteArticleByTD(articleID);
    }

    @Override
    public int updateArticleByID(Article article) {
        return articleDao.updateArticleByID(article);
    }

    @Override
    public int addReadNum() {
        return articleDao.addReadNum();
    }
}
