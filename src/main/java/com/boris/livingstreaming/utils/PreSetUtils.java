package com.boris.livingstreaming.utils;

import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.Audio;
import com.baidubce.services.lss.model.Hls;
import com.baidubce.services.lss.model.Rtmp;
import com.baidubce.services.lss.model.Video;

/**
 * 转码模板
 * Created by Qloop on 2017/3/14.
 */
public class PreSetUtils {

    /**
     * 创建一个转码的PreSet
     *
     * @param client
     * @param name
     * @param description
     * @param audio
     * @param video
     * @param hls
     * @param rtmp
     */
    public static void createPreset(LssClient client, String name, String description, Audio audio,
                             Video video, Hls hls, Rtmp rtmp) {
        client.createPreset(name, description, audio, video, hls, rtmp, null, null);
    }


    /**
     * 查询所有的Preset
     */
    public static String listPreset(LssClient client) {
        return client.listPresets().toString();
    }

    /**
     * 查询指定的Preset信息
     */
    public static String getPreset(LssClient client, String name) {
        return client.getPreset(name).toString();
    }

    /**
     * 删除指定的Preset
     */
    public static void deletePreset(LssClient client, String name) {
        client.deletePreset(name);
    }
}
