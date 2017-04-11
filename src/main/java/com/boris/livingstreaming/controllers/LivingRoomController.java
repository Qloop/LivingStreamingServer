package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.model.ApplyPushInfoDto;
import com.boris.livingstreaming.service.ApplyPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Qloop on 2017/3/9.
 */
@RestController
@RequestMapping("/living")
public class LivingRoomController {

    @Autowired
    private ApplyPushService applyPushService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/apply_push_url", method = RequestMethod.GET)
    public ApplyPushInfoDto applyPushUrl(String description) {
        return applyPushService.applyPushUrl(description);
    }

}
