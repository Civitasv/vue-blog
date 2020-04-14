package com.blog.application.mapper;

import com.blog.application.model.Article;
import com.blog.application.model.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelMapper {

    // 得到所有标签
    List<Label> getAllLabels();

    int insertLabel(String label);

    // 根据获得标签
    Label getLabelByContent(String content);

}
