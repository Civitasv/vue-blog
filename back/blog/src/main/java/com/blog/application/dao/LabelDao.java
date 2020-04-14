package com.blog.application.dao;

import com.blog.application.model.Article;
import com.blog.application.model.Label;

import java.util.List;

public interface LabelDao {

    // 得到所有标签
    List<Label> getAllLabels();

    // 根据ID获得标签
    Label getLabelByContent(String content);

    int insertLabel(String label);
}
