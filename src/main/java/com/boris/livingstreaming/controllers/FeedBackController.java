package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Qloop on 2017/5/4.
 */
@RestController
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/feedback")
    public String feedback(String content, String mail) {
        return feedbackService.saveContent(content, mail);
    }
}
