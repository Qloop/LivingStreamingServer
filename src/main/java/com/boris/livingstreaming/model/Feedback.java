package com.boris.livingstreaming.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Qloop on 2017/5/4.
 */
@Entity
@Table(name = "t_feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String content;
    private String mail;

    public Feedback(String content, String mail) {
        this.content = content;
        this.mail = mail;
    }

    public Feedback() {
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getMail() {
        return mail;
    }
}
