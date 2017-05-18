package com.boris.livingstreaming.service;

import com.boris.livingstreaming.Dto.UserInfoDto;
import com.boris.livingstreaming.config.Config;
import com.boris.livingstreaming.dao.UserDao;
import com.boris.livingstreaming.model.User;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Explorer on 2016/5/4.
 */
@Service
public class FileUploadService {
    @Autowired
    private UserDao userDao;

    @Autowired
    HttpServletRequest httpServletRequest;

    public String saveAvatar(String mail, String avatar) {
        // 获取文件类型 .**
        String type = ".png";
        // 取当前时间戳为文件名
        String filename = System.currentTimeMillis() + type;
        // 存放位置
        String path1 = httpServletRequest.getSession().getServletContext()
                .getRealPath("/upload/" + filename);
        String path = "/var/www/live" + "/avatar/" + filename;
        BASE64Decoder decoder = new BASE64Decoder();
        FileOutputStream write = null;
        try {
            File destFile = new File(path);
            write = new FileOutputStream(destFile);
            byte[] decoderBytes = decoder.decodeBuffer(avatar);
            write.write(decoderBytes);

            User userInfo = userDao.findByMail(mail);
            userInfo.setAvatar(Config.BASE_URL + destFile.getAbsolutePath().replace("/var/www", ""));
            userDao.save(userInfo);
            return userInfo.getAvatar();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path1;
    }

    public UserInfoDto getAvatar(String mail) {
        User user = userDao.findByMail(mail);
        UserInfoDto userInfoDto = new UserInfoDto();
        if (!TextUtils.isEmpty(user.getAvatar())) {
            userInfoDto.setResult("success");
            userInfoDto.setAvatar(user.getAvatar());
            return userInfoDto;
        } else {
            userInfoDto.setResult("failed");
            return userInfoDto;
        }
    }

}
