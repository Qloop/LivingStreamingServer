package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Qloop on 2017/4/9.
 */
@Entity
@Table(name = "t_subscribe")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long subscriberId;

    @NotNull
    private String liveRoomPullUrl;

    public Subscribe() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSubscriberId(long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public void setLiveRoomPullUrl(String liveRoomPullUrl) {
        this.liveRoomPullUrl = liveRoomPullUrl;
    }

    public long getId() {
        return id;
    }

    public long getSubscriberId() {
        return subscriberId;
    }

    public String getLiveRoomPullUrl() {
        return liveRoomPullUrl;
    }
}
