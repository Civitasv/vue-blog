package com.blog.application.mapper;

import com.blog.application.model.Article2Label;
import com.blog.application.model.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Article2LabelMapper {
    int insert(List<Article2Label> list);
}
