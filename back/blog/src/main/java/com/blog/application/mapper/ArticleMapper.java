package com.blog.application.mapper;

import com.blog.application.model.Article;
import com.blog.application.model.Comment;
import com.blog.application.model.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

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
