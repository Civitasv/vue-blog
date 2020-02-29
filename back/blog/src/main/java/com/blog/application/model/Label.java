package com.blog.application.model;

import lombok.Data;

import java.util.List;

/**
 * 标签
 */
@Data
public class Label {
    // id
    private int labelID;
    // 1--java 2--c++
    // 值
    private String label;
    // Articles
    private List<Article> articles;
}
