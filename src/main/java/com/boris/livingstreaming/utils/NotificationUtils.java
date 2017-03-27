package com.boris.livingstreaming.utils;

import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.GetNotificationResponse;
import com.baidubce.services.lss.model.ListNotificationsResponse;

/**
 * Created by Qloop on 2017/3/14.
 */
public class NotificationUtils {


    public static void createNotification(LssClient client, String name, String endpoint) {
        client.createNotification(name, endpoint);
    }

    /**
     * 查询所有的Notification
     */
    public static String listNotifications(LssClient client) {
        ListNotificationsResponse response = client.listNotifications();
        return response.toString();
    }

    /**
     * 查询指定的Notification信息
     */
    public static String getNotification(LssClient client, String name) {
        GetNotificationResponse resp = client.getNotification(name);
        return resp.getName() + "+" + resp.getEndpoint();
    }

    /**
     * 删除一个NOtification信息
     */
    public static void deleteNotification(LssClient client, String name) {
        client.deleteNotification(name);
    }
}
