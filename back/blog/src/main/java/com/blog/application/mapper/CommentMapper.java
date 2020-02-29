package com.blog.application.mapper;

import com.blog.application.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 添加评论
    int insertComment(int articleID,Comment comment);

    // 删除评论
    int deleteCommentByID(int commentID);
}
