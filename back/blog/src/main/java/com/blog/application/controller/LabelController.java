package com.blog.application.controller;

import com.blog.application.model.Article;
import com.blog.application.model.Label;
import com.blog.application.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest服务
 */
@RestController
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    LabelService labelService;

    @GetMapping("/")
    public List<Label> getAllLabels(){
        List<Label> labelList = labelService.getAllLabels();

        return labelList;
    }

    @GetMapping("/{content}")
    public Label getLabelByID(@PathVariable String content){
        Label label = labelService.getLabelByContent(content);
        return label;
    }
}
