package com.blog.application.model;

import lombok.Data;

import java.util.List;

/**
 * 标签
 */
@Data
public class Label {
    // 值
    private String label;
    // Articles
    private List<Article> articles;
}
