package com.blog.application;

import com.blog.application.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }

    public static void main(String[] args) {
        // Spring应用启动
        SpringApplication s = new SpringApplication();
        // 懒初始化
        s.setLazyInitialization(true);
        s.run(MyApplication.class, args);
    }


}