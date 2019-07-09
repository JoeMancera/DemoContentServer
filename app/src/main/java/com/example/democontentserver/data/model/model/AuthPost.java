package com.example.democontentserver.data.model.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthPost {

    @SerializedName("ticket")
    @Expose
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    //Para agregar Alt + Insert
    @Override
    public String toString() {
        return "AuthPost{" +
                "ticket='" + ticket + '\'' +
                '}';
    }
}