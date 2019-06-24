package com.flattery.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity // This tells Hibernate to make a table out of this class
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer Wohnung_id;
    private Integer User_id;

    public Integer getWohnung_id() {
        return Wohnung_id;
    }

    public void setWohnung_id(Integer wohnung_id) {
        Wohnung_id = wohnung_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }
}
