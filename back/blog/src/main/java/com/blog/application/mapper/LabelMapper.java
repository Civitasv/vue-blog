package com.blog.application.mapper;

import com.blog.application.model.Article;
import com.blog.application.model.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelMapper {

    // 得到所有标签
    List<Label> getAllLabels();

    // 根据ID获得标签
    Label getLabelByID(int labelID);

}
