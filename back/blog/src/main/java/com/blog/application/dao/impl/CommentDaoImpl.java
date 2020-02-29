package com.blog.application.dao.impl;

import com.blog.application.dao.CommentDao;
import com.blog.application.mapper.ArticleMapper;
import com.blog.application.mapper.CommentMapper;
import com.blog.application.model.Comment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    // 此种方式注入的sqlSession实质上为sqlSessionTemplate，不需要手动关闭
    private final SqlSession sqlSession;

    public CommentDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertComment(int articleID, Comment comment) {
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        return mapper.insertComment(articleID,comment);
    }

    @Override
    public int deleteCommentByID(int commentID) {
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        return mapper.deleteCommentByID(commentID);
    }
}
