package com.blog.application.dao;

import com.blog.application.model.User;

public interface UserDao {
    User get(String username, String password);
}
