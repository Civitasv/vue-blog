package com.blog.application.model;

import lombok.Data;

import java.util.List;

/**
 * 文章
 */
@Data
public class Article {
    // id
    private int articleID;
    // 发布时间
    private long publicTime;
    // 标题
    private String title;
    // 摘要
    private String digest;
    // 内容
    private String content;
    // 热度
    private double heat;
    // 点赞数
    private int commendNum;
    // 阅读量
    private int readNum;
    // 标签 和 标签 多对多
    private List<Label> labels;
    // 评论 一对多
    private List<Comment> comments;

}
