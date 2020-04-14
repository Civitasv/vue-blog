package com.blog.application.dao.impl;

import com.blog.application.dao.Article2LabelDao;
import com.blog.application.mapper.Article2LabelMapper;
import com.blog.application.model.Article2Label;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Article2LabelDaoImpl implements Article2LabelDao {
    // 此种方式注入的sqlSession实质上为sqlSessionTemplate，不需要手动关闭
    private final SqlSession sqlSession;

    public Article2LabelDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insert(List<Article2Label> list) {
        Article2LabelMapper mapper = sqlSession.getMapper(Article2LabelMapper.class);
        return mapper.insert(list);
    }
}
