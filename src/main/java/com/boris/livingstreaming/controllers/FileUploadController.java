package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.Dto.UserInfoDto;
import com.boris.livingstreaming.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/4.
 */
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/save_avatar", method = RequestMethod.POST)
    public String saveAvatar(String mail, String avatar) {
        return fileUploadService.saveAvatar(mail, avatar);
    }

    @RequestMapping(value = "/get_avatar")
    public UserInfoDto getAvatar(String mail) {
        return fileUploadService.getAvatar(mail);
    }
}
