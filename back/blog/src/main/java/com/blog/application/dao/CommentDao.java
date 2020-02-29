package com.blog.application.dao;

import com.blog.application.model.Comment;

import java.util.List;

public interface CommentDao {
    // 添加评论
    int insertComment(int articleID,Comment comment);

    // 删除评论
    int deleteCommentByID(int commentID);
}
