package com.boris.livingstreaming.Dto;

/**
 * Created by Qloop on 2017/5/2.
 */
public class UserInfoDto {

    private String result;
    private String password;
    private String mail;
    private String nickname;
    private int id;
    private String liveRoom;
    private Object avatar;


    public void setLiveRoom(String liveRoom) {
        this.liveRoom = liveRoom;
    }

    public String getLiveRoom() {
        return liveRoom;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }
}
