package com.blog.application.controller;


import com.blog.application.model.Article;
import com.blog.application.model.User;
import com.blog.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public int login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        User user = userService.get(username, requestUser.getPassword());

        if (null == user) {
            return 400;
        } else {
            return 200;
        }
    }

    @PostMapping("/save")
    public String save(@RequestBody Article artcile) {
        return "";
    }

}
