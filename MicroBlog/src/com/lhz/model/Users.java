package com.lhz.model;

import java.sql.Timestamp;

public class Users {

    private String user_id;
    private String user_phone;
    private String user_email;
    private String user_password;
    private String user_nikename;
    private Timestamp user_time;
    private int user_status;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_nikename() {
        return user_nikename;
    }

    public void setUser_nikename(String user_nikename) {
        this.user_nikename = user_nikename;
    }

    public Timestamp getUser_time() {
        return user_time;
    }

    public void setUser_time(Timestamp user_time) {
        this.user_time = user_time;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
}
