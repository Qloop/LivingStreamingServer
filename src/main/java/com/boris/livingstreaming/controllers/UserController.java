package com.boris.livingstreaming.controllers;

import com.boris.livingstreaming.Dto.UserInfoDto;
import com.boris.livingstreaming.dao.UserDao;
import com.boris.livingstreaming.model.User;
import com.boris.livingstreaming.service.UserService;
import com.boris.livingstreaming.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user_info")
    public UserInfoDto getUserInfo(String mail) {
        return userService.getUserInfo(mail);
    }

    @RequestMapping("/login")
    public String doLogin(String email, String password) {
        return userService.login(email, password);
    }

    /**
     * 验证邮件回执处理
     */
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    @ResponseBody
    public String validate(String name, Double validateCode, Date sendDate) {
        System.out.println("用户名 is " + name);
        return userService.validationEmail(name, validateCode, sendDate);
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> signUp(String name, String mail, String password) {
        return userService.createAccount(name, mail, password);
    }

    /**
     * 发送重置密码邮件
     */
    @RequestMapping(value = "/reset_mail", method = RequestMethod.POST)
    @ResponseBody
    public boolean resetPwd(String mail) {
        return userService.resetPwd(mail);
    }

}
