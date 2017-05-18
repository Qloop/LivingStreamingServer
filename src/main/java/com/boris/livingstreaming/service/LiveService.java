package com.boris.livingstreaming.service;

import com.boris.livingstreaming.Dto.LiveListDto;
import com.boris.livingstreaming.dao.LiveDao;
import com.boris.livingstreaming.model.LiveRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Qloop on 2017/5/17.
 */
@Service
public class LiveService {


    @Autowired
    private LiveDao liveDao;


    private Sort sortByExpDesc() {
        return new Sort(Sort.Direction.DESC, "exp");
    }


    public LiveListDto getLiveList() {
        LiveListDto liveListDto = new LiveListDto();
        liveListDto.liveList = new ArrayList<>();
        Iterable<LiveRoom> liveRoomList = liveDao.findAll(sortByExpDesc());
        for (LiveRoom liveRoom : liveRoomList) {
            LiveListDto.LiveListEntity liveListEntity = new LiveListDto().new LiveListEntity();
            liveListEntity.setImg(liveRoom.getThumbnail());
            liveListEntity.setLiveName(liveRoom.getDescription());
            liveListEntity.setWatchCount(liveRoom.getWatchCount() + "");
            liveListEntity.setLiveRoomName(liveRoom.getTitle());
            liveListEntity.setMail(liveRoom.getMail());
            liveListEntity.setPullUrl(liveRoom.getPullUrl());
            liveListDto.liveList.add(liveListEntity);
        }

        return liveListDto;
    }

}



