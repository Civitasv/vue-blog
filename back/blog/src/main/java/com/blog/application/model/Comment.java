package com.blog.application.model;

import lombok.Data;

import javax.validation.constraints.Email;

/**
 * 评论
 */
@Data
public class Comment {
    // id
    private int commentID;
    // 内容
    private String content;
    // 时间
    private double commentTime;
    // 点赞数
    private int commentNum;
    // 评论人
    private String commentName;
    // 邮件信息
    private String email;
}
