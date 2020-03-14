package com.blog.application.controller;

import com.blog.application.model.Article;
import com.blog.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest服务
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public List<Article> getAllArticles(){
        List<Article> articleList = articleService.getAllArticles();
        return articleList;
    }

    @GetMapping("/{articleID}")
    public Article getArticleByID(@PathVariable int articleID){
        Article article = articleService.getArticleByID(articleID);
        return article;
    }
}
