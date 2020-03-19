package com.blog.application.service.impl;

import com.blog.application.dao.LabelDao;
import com.blog.application.model.Label;
import com.blog.application.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelDao labelDao;

    @Override
    public List<Label> getAllLabels() {
        return labelDao.getAllLabels();
    }

    @Override
    public Label getLabelByID(int labelID) {
        return labelDao.getLabelByID(labelID);
    }
}
