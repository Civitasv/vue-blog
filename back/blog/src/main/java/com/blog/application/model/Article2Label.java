package com.blog.application.model;

import lombok.Data;

@Data
public class Article2Label {
    private Integer articleID;

    private String label;

    public Article2Label(Integer articleID, String label) {
        this.articleID = articleID;
        this.label = label;
    }

    public Article2Label() {
    }
}
