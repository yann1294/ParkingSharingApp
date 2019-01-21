package com.example.a6god_tha_godfather_.parkingsharingapp.model;

public class Client {

    String clientId;
    String clientName;
    String clientMail;
    String clientCarModel;
    String clientPwd;

    public Client() {
    }

    public Client(String clientId, String clientName, String clientMail, String clientCarModel, String clientPwd) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientMail = clientMail;
        this.clientCarModel = clientCarModel;
        this.clientPwd = clientPwd;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getClientCarModel() {
        return clientCarModel;
    }

    public void setClientCarModel(String clientCarModel) {
        this.clientCarModel = clientCarModel;
    }

    public String getClientPwd() {
        return clientPwd;
    }

    public void setClientPwd(String clientPwd) {
        this.clientPwd = clientPwd;
    }
}
