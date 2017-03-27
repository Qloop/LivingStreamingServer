package com.boris.livingstreaming.model;

/**
 * Created by Qloop on 2017/3/27.
 */
public class ApplyPushInfo {

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
