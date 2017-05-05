package com.boris.livingstreaming.service;

import com.boris.livingstreaming.dao.FeedbackDao;
import com.boris.livingstreaming.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Qloop on 2017/5/4.
 */
@Service
public class FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    private static final String SAVE_SUCCESS = "success";

    public String saveContent(String content, String mail) {
        Feedback feedback = new Feedback(content, mail);
        feedbackDao.save(feedback);
        return SAVE_SUCCESS;
    }
}
