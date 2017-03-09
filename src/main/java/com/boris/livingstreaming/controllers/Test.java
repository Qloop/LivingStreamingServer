package com.boris.livingstreaming.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Qloop on 2017/3/9.
 */
@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String Hello(){
        return "Hello World!";
    }
}
