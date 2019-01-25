package com.example.a6god_tha_godfather_.parkingsharingapp.model;

public class Owner {

    String ownerId;
    String ownerName;
    String ownerMail;
    String ownerPwd;

    public Owner() {
    }

    public Owner(String ownerId, String ownerName, String ownerMail, String ownerPwd) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerMail = ownerMail;
        this.ownerPwd = ownerPwd;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }


    public String getOwnerPwd() {
        return ownerPwd;
    }

    public void setOwnerPwd(String ownerPwd) {
        this.ownerPwd = ownerPwd;
    }
}
