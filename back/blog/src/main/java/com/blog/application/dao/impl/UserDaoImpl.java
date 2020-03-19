package com.blog.application.dao.impl;

import com.blog.application.dao.UserDao;
import com.blog.application.mapper.UserMapper;
import com.blog.application.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    // 此种方式注入的sqlSession实质上为sqlSessionTemplate，不需要手动关闭
    private final SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public User get(String username, String password) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.get(username,password);
    }
}
