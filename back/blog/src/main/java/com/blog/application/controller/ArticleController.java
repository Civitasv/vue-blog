package com.blog.application.controller;

import com.blog.application.model.Article;
import com.blog.application.service.ArticleService;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public List<Article> getAllArticles() {
        List<Article> articleList = articleService.getAllArticles();
        return articleList;
    }

    @GetMapping("/{articleID}")
    public Article getArticleByID(@PathVariable int articleID) {
        Article article = articleService.getArticleByID(articleID);
        return article;
    }

    @GetMapping("/info/{articleID}")
    public String getArticleInfoByID(@PathVariable int articleID) {
        Article article = articleService.getArticleByID(articleID);
        return article.getTitle();
    }

    @PostMapping("/")
    public int saveArticle(@RequestBody String data) {
        JSONObject jsonObject = new JSONObject(data);
        JSONObject jsonObject1 = jsonObject.getJSONObject("article");
        Article article = new Article();
        article.setTitle(jsonObject1.getString("title"));
        article.setContent(jsonObject1.getString("content"));
        article.setDigest(jsonObject1.getString("digest"));
        try {
            article.setPublicTime(jsonObject1.getLong("publicTime"));
        } catch (Exception e) {
            article.setPublicTime(0);
        }
        JSONArray labels = jsonObject.getJSONArray("labels");
        String[] labelLis = new String[labels.length()];
        for (int i = 0; i < labels.length(); i++) {
            labelLis[i] = labels.getString(i);
        }
        return articleService.insertArticle(article, labelLis);
    }

    @DeleteMapping("/{articleID}")
    public int deleteArticle(@PathVariable int articleID){
        return articleService.deleteArticleByTD(articleID);
    }

    @PutMapping("/")
    public int updateArticle(@RequestBody Article article){
        return articleService.updateArticleByID(article);
    }

    @PutMapping("/read")
    public int addReadNum(){
        return articleService.addReadNum();
    }
}
