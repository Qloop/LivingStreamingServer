package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by boris on 17/3/9.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String nickname;
    private String avatar;
    private String password;
    private String liveRoom; //创建的直播间地址
    //订阅的直播间 由id去t_subscribe表查找

    @NotNull
    private int status;  //账户状态 0:未验证 1:正常 -1: 封号


    @NotNull
    private Date createDate;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLiveRoom(String liveRoom) {
        this.liveRoom = liveRoom;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public String getLiveRoom() {
        return liveRoom;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
