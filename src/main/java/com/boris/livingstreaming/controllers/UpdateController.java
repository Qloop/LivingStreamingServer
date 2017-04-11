package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.Dto.UpdateInfoDto;
import com.boris.livingstreaming.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Qloop on 2017/4/10.
 */
@RestController
@RequestMapping(value = "/update")
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public UpdateInfoDto checkUpdate() {
        return updateService.checkUpdate();
    }
}
