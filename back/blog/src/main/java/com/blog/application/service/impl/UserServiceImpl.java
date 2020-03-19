package com.blog.application.service.impl;

import com.blog.application.dao.UserDao;
import com.blog.application.model.User;
import com.blog.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User get(String username, String password) {
        return userDao.get(username,password);
    }
}
