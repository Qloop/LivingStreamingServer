package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 版本更新信息
 * Created by Qloop on 2017/4/9.
 */
@Entity
@Table(name = "t_update")
public class UpdateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private double versionCode;
    private String versionName;
    private String updateInfo;
    private String downloadUrl;


    @NotNull
    private Date createDate;

    public UpdateInfo() {
    }


    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setVersionCode(double versionCode) {
        this.versionCode = versionCode;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public double getVersionCode() {
        return versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
