package com.blog.application.controller;

import com.blog.application.dao.ArticleDao;
import com.blog.application.model.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class Hello {

    @RequestMapping("/hello")
    String home() {

        return "hello world";
    }

    @RequestMapping("/getData")
    public ModelAndView data(HttpServletResponse response) throws IOException {

        return null;
    }
}
