package com.boris.livingstreaming.service;

import com.boris.livingstreaming.Dto.UpdateInfoDto;
import com.boris.livingstreaming.dao.UpdateDao;
import com.boris.livingstreaming.model.UpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Qloop on 2017/4/10.
 */
@Service
public class UpdateService {

    @Autowired
    private UpdateDao updateDao;

    public UpdateInfoDto checkUpdate() {
        Iterable<UpdateInfo> updateInfos = updateDao.findAll();
        UpdateInfo updateInfo = updateInfos.iterator().next();
        UpdateInfoDto updateInfoDto = new UpdateInfoDto();
        updateInfoDto.setVersionCode(updateInfo.getVersionCode());
        updateInfoDto.setVersionName(updateInfo.getVersionName());
        updateInfoDto.setUpdateInfo(updateInfo.getUpdateInfo());
        updateInfoDto.setDownloadUrl(updateInfo.getDownloadUrl());
        return updateInfoDto;
    }
}
