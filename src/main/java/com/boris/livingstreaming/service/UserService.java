package com.boris.livingstreaming.service;

import com.boris.livingstreaming.config.Config;
import com.boris.livingstreaming.dao.UserDao;
import com.boris.livingstreaming.model.User;
import com.boris.livingstreaming.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qloop on 2017/4/26.
 */
@Service
public class UserService {

    private static final double MODULUS = 2.56;//验证码计算系数

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserDao userDao;

    public User getUserInfo(String mail) {
        User customUser = null;
        try {
            customUser = userDao.findByMail(mail);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customUser;
    }

    public String login(String email, String password){
        User customUser = userDao.findByMail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, customUser.getPassword())) {
            httpSession.setAttribute("user", customUser);
            return "success";
        } else {
            return "failed";
        }
    }

    /**
     * 验证邮件回执 验证
     */
    public String validationEmail(String name, Double validateCode, Date sendDate){
        Date currentDate = new Date();
        long timeSpan = currentDate.getTime() - sendDate.getTime();
        if (name.length() * MODULUS != validateCode) {
            return "非法的验证邮件";
        } else if ((timeSpan / 1000 / 60 / 60) > 48) {
            return "验证邮件失效，请回到客户端重新申请验证邮件";
        } else {
            User customUser = userDao.findByNickname(name);
            if (customUser != null) {
                customUser.setStatus(1);
                userDao.save(customUser);
                return "验证成功";
            } else {
                return "验证失败  没有此用户 请尝试重新注册";
            }
        }
    }

    /**
     * 注册
     */
    public Map<String, Object> createAccount(String name, String mail, String password) {
        System.out.println("name: " + name + "mail " + mail + "password " + password);
        User customUser = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Map<String, Object> userInfo = new HashMap<>();
        if (userDao.findByNickname(name) == null) {
            try {
                customUser = new User(mail, name, passwordEncoder.encode(password), Config.STATUS_UNAUTHORIZED,new Date());
                userDao.save(customUser);
                userInfo.put("result", "注册成功");
                userInfo.put("id", customUser.getId());
                userInfo.put("nickname", customUser.getNickname());
                userInfo.put("avatar", customUser.getAvatar());
                userInfo.put("password", customUser.getPassword());
                userInfo.put("mail", customUser.getMail());

                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时有效，否则重新注册账号，链接只能使用一次，请尽快激活 ！</br>");
                sb.append("<a href=\"http://118.89.112.50:8082/user/validate?&name=");
                sb.append(name);
                sb.append("&validateCode=");
                Double validateCode = name.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://118.89.112.50:8082/validate?&mail=");
                sb.append(name);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return userInfo;
            } catch (Exception ex) {
                ex.printStackTrace();
                userInfo.put("result", "注册失败");
                return userInfo;
            }
        } else {
            userInfo.put("result", "用户已存在");
            return userInfo;
        }
    }

    /**
     * 重置密码
     */
    public boolean resetPwd(String mail){
        System.out.println("mail " + mail);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userDao.findByMail(mail) != null) {
            try {
                ///邮件的内容
                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://118.89.112.50:8082/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                Double validateCode = mail.length() * MODULUS;
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("\">http://118.89.112.50:8082/reset_pager?&mail=");
                sb.append(mail);
                sb.append("&validateCode=");
                sb.append(validateCode);
                sb.append("&sendDate=");
                sb.append(new Date());
                sb.append("</a>");

                //发送邮件
                MailUtils.send(mail, sb.toString());
                System.out.println("发送邮件");
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

}
