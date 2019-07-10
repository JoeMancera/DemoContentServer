package com.example.democontentserver.data.model.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthPost {

    @SerializedName("username")
    @Expose
    private String username;

    public String getUserName() {
        return username;
    }

    public void setUsername(String ticket) {
        this.username = username;
    }

    @SerializedName("password")
    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //Para agregar Alt + Insert


    @Override
    public String toString() {
        return "AuthPost{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}