package com.flattery.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity // This tells Hibernate to make a table out of this class
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer wohnungID;
    private Integer userID;

    public Integer getWohnungID() {
        return wohnungID;
    }

    public void setWohnungID(Integer wohnungID) {
        this.wohnungID = wohnungID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
