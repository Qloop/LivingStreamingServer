package com.boris.livingstreaming.Dto;

/**
 * Created by Qloop on 2017/4/9.
 */
public class UpdateInfoDto {


    /**
     * updateInfo : 测试版本
     * downloadUrl : http://www.tzloop.com/...
     * versionName : 1.1
     * versionCode : 1.1
     */
    private String updateInfo;
    private String downloadUrl;
    private String versionName;
    private double versionCode;

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setVersionCode(double versionCode) {
        this.versionCode = versionCode;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public double getVersionCode() {
        return versionCode;
    }
}
