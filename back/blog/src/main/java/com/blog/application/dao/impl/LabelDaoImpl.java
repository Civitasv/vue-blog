package com.blog.application.dao.impl;

import com.blog.application.dao.LabelDao;
import com.blog.application.mapper.ArticleMapper;
import com.blog.application.mapper.LabelMapper;
import com.blog.application.model.Article;
import com.blog.application.model.Label;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabelDaoImpl implements LabelDao {

    // 此种方式注入的sqlSession实质上为sqlSessionTemplate，不需要手动关闭
    private final SqlSession sqlSession;

    public LabelDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Label> getAllLabels() {
        LabelMapper mapper = sqlSession.getMapper(LabelMapper.class);
        return mapper.getAllLabels();
    }

    @Override
    public Label getLabelByContent(String content) {
        LabelMapper mapper = sqlSession.getMapper(LabelMapper.class);
        return mapper.getLabelByContent(content);
    }

    @Override
    public int insertLabel(String label) {
        LabelMapper mapper = sqlSession.getMapper(LabelMapper.class);
        return mapper.insertLabel(label);
    }
}
