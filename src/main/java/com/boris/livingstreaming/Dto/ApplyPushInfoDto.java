package com.boris.livingstreaming.Dto;

/**
 * 请求推送直播数据流的地址
 * Created by Qloop on 2017/3/27.
 */
public class ApplyPushInfoDto {

    private String rtmp;
    private int errorCode;

    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getRtmp() {
        return rtmp;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
