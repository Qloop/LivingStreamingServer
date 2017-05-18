package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by boris on 17/3/9.
 */
@Entity
@Table(name = "t_communication")
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String content;
    private String nickname;


    @NotNull
    private Date createDate;

    public Communication() {
    }

    public Communication(String content, String nickname, Date createDate) {
        this.content = content;
        this.nickname = nickname;
        this.createDate = createDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
