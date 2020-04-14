package com.blog.application.dao.impl;

import com.blog.application.dao.ArticleDao;
import com.blog.application.mapper.Article2LabelMapper;
import com.blog.application.mapper.ArticleMapper;
import com.blog.application.model.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    // 此种方式注入的sqlSession实质上为sqlSessionTemplate，不需要手动关闭
    private final SqlSession sqlSession;

    public ArticleDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Article> getAllArticles() {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.getAllArticles();
    }

    @Override
    public Article getArticleByID(int articleID) {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.getArticleByID(articleID);
    }

    @Override
    public int insertArticle(Article article) {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.insertArticle(article);
    }

    @Override
    public int deleteArticleByTD(int articleID) {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.deleteArticleByTD(articleID);
    }

    @Override
    public int updateArticleByID( Article article) {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.updateArticleByID(article);
    }

    @Override
    public int addReadNum() {
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        return mapper.addReadNum();
    }
}
