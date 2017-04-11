package com.boris.livingstreaming.service;

import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.CreateSessionResponse;
import com.boris.livingstreaming.config.Config;
import com.boris.livingstreaming.model.ApplyPushInfoDto;
import com.boris.livingstreaming.utils.LssClientUtils;
import com.boris.livingstreaming.utils.SessionUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Qloop on 2017/3/27.
 */
@Service
public class ApplyPushService {

    public ApplyPushInfoDto applyPushUrl(String description) {
        ApplyPushInfoDto applyPushInfoDto = new ApplyPushInfoDto();
        LssClient client = LssClientUtils.createLssClient();
        CreateSessionResponse pushSession = SessionUtils.createPushSession(client, description);
        if (pushSession != null && pushSession.getPublish() != null) {
            applyPushInfoDto.setRtmp(pushSession.getPublish().getPushUrl());
        } else {
            applyPushInfoDto.setErrorCode(Config.APPLY_PUSH_FAILED);
        }

        return applyPushInfoDto;
    }
}
