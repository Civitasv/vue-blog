package com.blog.application.mapper;

import com.blog.application.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User get(String username,String password);
}
