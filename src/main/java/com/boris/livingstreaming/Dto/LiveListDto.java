package com.boris.livingstreaming.Dto;

import java.util.List;

/**
 * Created by Qloop on 2017/5/17.
 */
public class LiveListDto {


    /**
     * liveList : [{"img":"http://www.tzloop.com/live/thumbnail/thumbnail1.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail2.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail3.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail2.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail1.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail2.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail3.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail2.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"},{"img":"http://www.tzloop.com/live/thumbnail/thumbnail1.jpg","liveRoomName":"KPL职业联赛","liveName":"KPL王者荣耀职业联赛","watchCount":"37.7万"}]
     */
    public List<LiveListEntity> liveList;

    public void setLiveList(List<LiveListEntity> liveList) {
        this.liveList = liveList;
    }

    public List<LiveListEntity> getLiveList() {
        return liveList;
    }

    public class LiveListEntity {
        /**
         * img : http://www.tzloop.com/live/thumbnail/thumbnail1.jpg
         * liveRoomName : KPL职业联赛
         * liveName : KPL王者荣耀职业联赛荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联荣耀职业联
         * watchCount : 37.7万
         */
        private String img;
        private String liveRoomName;
        private String liveName;
        private String watchCount;
        private String pullUrl;
        private String mail;

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getMail() {
            return mail;
        }

        public void setPullUrl(String pullUrl) {
            this.pullUrl = pullUrl;
        }

        public String getPullUrl() {
            return pullUrl;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setLiveRoomName(String liveRoomName) {
            this.liveRoomName = liveRoomName;
        }

        public void setLiveName(String liveName) {
            this.liveName = liveName;
        }

        public void setWatchCount(String watchCount) {
            this.watchCount = watchCount;
        }

        public String getImg() {
            return img;
        }

        public String getLiveRoomName() {
            return liveRoomName;
        }

        public String getLiveName() {
            return liveName;
        }

        public String getWatchCount() {
            return watchCount;
        }
    }
}
