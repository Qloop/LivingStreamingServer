package com.boris.livingstreaming.Dto;

/**
 * Created by Qloop on 2017/5/17.
 */
public class CommunicationDto {

    private String result;
    private String nickname;
    private String content;

    public CommunicationDto() {
    }

    public CommunicationDto(String result, String nickname, String content) {
        this.result = result;
        this.nickname = nickname;
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContent() {
        return content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
