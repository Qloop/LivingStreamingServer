package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by boris on 17/3/9.
 */
@Entity
@Table(name = "t_live")
public class LiveRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sessionId;

    private String thumbnail;

    @NotNull
    private String mail;
    private String nickname;
    private String title;
    private String liveRoom; //创建的直播间地址
    private String classify;// 分类
    private int watchCount = 0;//观看人数
    private String description;
    private String pullUrl;


    @NotNull
    private Date createDate;

    public LiveRoom() {
    }

    public LiveRoom(String mail, String nickname, String title, String description, String liveRoom, String pullUrl, String classify, String sessionId, Date createDate) {
        this.mail = mail;
        this.nickname = nickname;
        this.title = title;
        this.liveRoom = liveRoom;
        this.classify = classify;
        this.sessionId = sessionId;
        this.createDate = createDate;
        this.description = description;
        this.pullUrl = pullUrl;
    }

    public void setPullUrl(String pullUrl) {
        this.pullUrl = pullUrl;
    }

    public String getPullUrl() {
        return pullUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getClassify() {
        return classify;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLiveRoom(String liveRoom) {
        this.liveRoom = liveRoom;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getLiveRoom() {
        return liveRoom;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(int watchCount) {
        this.watchCount = watchCount;
    }
}
