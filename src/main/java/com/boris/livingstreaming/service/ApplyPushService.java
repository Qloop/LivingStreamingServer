package com.boris.livingstreaming.service;

import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.CreateSessionResponse;
import com.baidubce.services.lss.model.GetSessionSourceInfoResponse;
import com.boris.livingstreaming.config.Config;
import com.boris.livingstreaming.dao.LiveDao;
import com.boris.livingstreaming.Dto.ApplyPushInfoDto;
import com.boris.livingstreaming.model.LiveRoom;
import com.boris.livingstreaming.utils.LssClientUtils;
import com.boris.livingstreaming.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Qloop on 2017/3/27.
 */
@Service
public class ApplyPushService {

    @Autowired
    private LiveDao liveDao;
    private Map<String, CreateSessionResponse> sessionMap = new HashMap<>();

    public ApplyPushInfoDto applyPushUrl(String title, String description, String mail, String nickname, String classify) {
        ApplyPushInfoDto applyPushInfoDto = new ApplyPushInfoDto();
        if (liveDao.findByMail(mail) != null) {
            applyPushInfoDto.setErrorCode(2);// 该用户已经存在直播间
        } else {
            LssClient client = LssClientUtils.createLssClient();
            CreateSessionResponse pushSession = SessionUtils.createPushSession(client, description);
            if (pushSession != null && pushSession.getPublish() != null) {
                applyPushInfoDto.setRtmp(pushSession.getPublish().getPushUrl());
                //保存直播间信息到数据表
                LiveRoom liveRoom = new LiveRoom(mail, nickname, title, description, applyPushInfoDto.getRtmp(),
                        pushSession.getPublish().getPullUrl(), classify, pushSession.getSessionId(), new Date());
                liveDao.save(liveRoom);
                sessionMap.put(mail, pushSession);
            } else {
                applyPushInfoDto.setErrorCode(Config.APPLY_PUSH_FAILED);
            }
        }
        return applyPushInfoDto;
    }

    public String getThumbnail(String mail) {
        CreateSessionResponse createSessionResponse = sessionMap.get(mail);
        return createSessionResponse.getThumbnail();
    }

    /**
     * 每次开始直播的时候 保存一次缩略图
     *
     * @param mail
     */
    public void setThumbnail(String mail) {
        CreateSessionResponse createSessionResponse = sessionMap.get(mail);
        LiveRoom liveRoom = liveDao.findByMail(mail);
        liveRoom.setThumbnail(createSessionResponse.getThumbnail());
        liveDao.save(liveRoom);
    }
}
