package com.blog.application.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private String baseFolderPath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\blogImage\\";

    @PostMapping("/")
    public String addImage(@RequestParam(name = "image", required = false) MultipartFile image, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filePath = sdf.format(new Date());
        File baseFolder = new File(baseFolderPath + filePath);
        if (!baseFolder.exists()) {
            baseFolder.mkdirs();
        }
        StringBuffer url = new StringBuffer();
        url.append(request.getScheme())
                .append("://")
                .append(request.getServerName())
                .append(":")
                .append(request.getServerPort())
                .append(request.getContextPath())
                .append("/blogImage/")
                .append(filePath);
        String imgName = UUID.randomUUID().toString().replace("_", "") + "_" + image.getOriginalFilename().replaceAll(" ", "");
        try {
            File dest = new File(baseFolder, imgName);
            FileCopyUtils.copy(image.getBytes(), dest);
            url.append("/").append(imgName);

            JSONObject object = new JSONObject();
            object.put("url", url);

            return object.toString();
        } catch (IOException e) {
            return "文件上传错误";
        }
    }
}

