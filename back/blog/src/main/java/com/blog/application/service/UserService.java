package com.blog.application.service;

import com.blog.application.model.User;

public interface UserService {
    User get(String username, String password);
}
