package com.boris.livingstreaming.utils;

import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.*;
import com.boris.livingstreaming.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 直播会话/事件
 * Created by Qloop on 2017/3/14.
 */
public class SessionUtils {


    /* 创建一个兼具水印、缩略图、多码率功能的推流Session */
    public static CreateSessionResponse createPushSession(LssClient lssClient, String description) {
//        String description = "test create session with thumbnail and watermarks";
//        String notification = "notification_name";  // 通知"notification_name"必须提前建立好
        LivePublishInfo publish = new LivePublishInfo();
        publish.setRegion("bj");
        ArrayList<String> presetList = new ArrayList<>();
        presetList.add("live.rtmp_hls_forward_only");  // 转码模板"preset_name_1"必须提前建立好
//        presetList.add("preset_name_2");  // 转码模板"preset_name_2"必须提前建立好
//        Watermarks watermarks = new Watermarks();
//        watermarks.setImage(Arrays.asList("lss_sdk_java_imw"));  // 图片水印"lss_sdk_java_imw"水印必须已经提前建立好
//        watermarks.setTimestamp(Arrays.asList("lss_sdk_java_tsw"));  // 时间戳水印"lss_sdk_java_tsw"水印必须已经提前建立好
        CreateSessionResponse resp = lssClient.createSession(description, presetList, null, null,
                null, publish, Config.THUMBNAIL_MODEL, null);  // 录制模板"lss_java_sdk"和缩略图"lss_java_sdk_thumbnail"必须提前建立好
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("presets: " + resp.getPresets());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        System.out.println("thumbnail: " + resp.getThumbnail());
        System.out.println("watermarks: " + resp.getWatermarks());
        if (resp.getPublish() != null) {
            System.out.println("push url: " + resp.getPublish().getPushUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null && resp.getPlay().getHlsUrls() != null) {
            System.out.println("hls urls: " + resp.getPlay().getHlsUrls());
        }
        if (resp.getPlay() != null && resp.getPlay().getRtmpUrls() != null) {
            System.out.println("rtmp urls: " + resp.getPlay().getRtmpUrls());
        }
        if (resp.getPlay() != null && resp.getPlay().getFlvUrls() != null) {
            System.out.println("flv urls: " + resp.getPlay().getFlvUrls());
        }
        return resp;
    }

    /* 创建一个拉流Session */
    public void createPullSession(LssClient client, String description, String preset, String notification,
                                  String securityPolicy, String recording, LivePublishInfo publish) {
        CreateSessionResponse resp = client.createSession(description, preset, notification, securityPolicy,
                recording, publish);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        if (resp.getPublish() != null) {
            System.out.println("pull url: " + resp.getPublish().getPullUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null && resp.getPlay().getHlsUrl() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
        }
        if (resp.getPlay() != null && resp.getPlay().getRtmpUrl() != null) {
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }

    /**
     * 查询所有的Session
     */
    public String listSessions(LssClient client) {
        ListSessionsResponse response = client.listSessions();
        return response.toString();
    }

    /**
     * 安全策略未开启推流/播放认证时 查询指定的Session信息
     *
     * @param client
     * @param sessionId
     */
    public void getSession(LssClient client, String sessionId) {
        GetSessionResponse resp = client.getSession(sessionId);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        System.out.println("streamingStatus: " + resp.getStreamingStatus());
        if (resp.getPublish() != null) {
            System.out.println("push url: " + resp.getPublish().getPushUrl());
            System.out.println("pull url: " + resp.getPublish().getPullUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }

    /**
     * 开启推流/播放认证 查询Session 返回带认证token的推流地址和播放地址
     *
     * @param client
     * @param sessionId
     * @param timeoutInMinute
     */
    public void getSessionWithToken(LssClient client, String sessionId, Integer timeoutInMinute) {
        GetSessionResponse resp = client.getSessionWithToken(sessionId, timeoutInMinute);
        System.out.println(resp.toString());
    }

    /**
     * 开始拉流  只对拉留Session有效
     */
    public void startPullSession(LssClient client, String sessionId) {
        client.startPullSession(sessionId);
    }

    /**
     * 暂停Session 不接收任何推流或拉流
     */
    public void pauseSession(LssClient client, String sessionId) {
        client.pauseSession(sessionId);
    }

    /**
     * 恢复Session 重新进入可以接收推流或拉流的状态
     */
    public void resumeSession(LssClient client, String sessionId) {
        client.resumeSession(sessionId);
    }

    /**
     * 刷新Session。刷新直播会话的[推流地址]，中断当前推流。
     */
    public void refreshSession(LssClient client, String sessionId) {
        RefreshSessionResponse resp = client.refreshSession(sessionId);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        System.out.println("streamingStatus: " + resp.getStreamingStatus());
        if (resp.getPublish() != null) {
            System.out.println("push url: " + resp.getPublish().getPushUrl());
            System.out.println("pull url: " + resp.getPublish().getPullUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }

    /**
     * 删除Session
     */
    public void deleteSession(LssClient client, String sessionId) {
        client.deleteSession(sessionId);
    }

    /**
     * 查询实时直播源信息
     */
    public String getSessionSourceInfo(LssClient client, String sessionId) {
        GetSessionSourceInfoResponse resp = client.getSessionSourceInfo(sessionId);
        System.out.println(resp.toString());
        return resp.toString();
    }

    /**
     * 插入提示点 curpoint 实现插入广告等功能
     */
    public void insertCuePoint(LssClient client, String sessionId, String callback,
                               Map<String, String> arguments) {
        client.insertCuePoint(sessionId, callback, arguments);
    }
}
