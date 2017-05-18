package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.Dto.ApplyPushInfoDto;
import com.boris.livingstreaming.Dto.LiveListDto;
import com.boris.livingstreaming.service.ApplyPushService;
import com.boris.livingstreaming.service.LiveService;
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
    @Autowired
    private LiveService liveService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/apply_push_url", method = RequestMethod.GET)
    public ApplyPushInfoDto applyPushUrl(String title, String description, String mail, String nickname, String classify) {
        return applyPushService.applyPushUrl(title, description, mail, nickname, classify);
    }

    @RequestMapping(value = "/get_all_live", method = RequestMethod.GET)
    public LiveListDto getAllLive() {
        return liveService.getLiveList();
    }

    @RequestMapping(value = "/set_thumbnail", method = RequestMethod.POST)
    public void setThumbnail(String mail) {
        applyPushService.setThumbnail(mail);
    }

}
