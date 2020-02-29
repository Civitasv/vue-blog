package com.blog.application.controller;

import com.blog.application.model.Article;
import com.blog.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest服务
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public Article getAllArticles(){
        List<Article> articleList = articleService.getAllArticles();
        Article article =  new Article();
        article.setTitle("测试");
        return article;
    }
}
