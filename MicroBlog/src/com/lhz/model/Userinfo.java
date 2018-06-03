package com.lhz.model;

import java.sql.Date;

public class Userinfo {
    private int userinfo_id;
    private String userinfo_name;
    private String userinfo_gender;
    private String userinfo_address;
    private Date userinfo_birth;
    private String userinfo_qq;
    private String userinfo_prof;
    private String userinfo_flag;
    private String user_id;

    public int getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(int userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public String getUserinfo_name() {
        return userinfo_name;
    }

    public void setUserinfo_name(String userinfo_name) {
        this.userinfo_name = userinfo_name;
    }

    public String getUserinfo_gender() {
        return userinfo_gender;
    }

    public void setUserinfo_gender(String userinfo_gender) {
        this.userinfo_gender = userinfo_gender;
    }

    public String getUserinfo_address() {
        return userinfo_address;
    }

    public void setUserinfo_address(String userinfo_address) {
        this.userinfo_address = userinfo_address;
    }

    public Date getUserinfo_birth() {
        return userinfo_birth;
    }

    public void setUserinfo_birth(Date userinfo_birth) {
        this.userinfo_birth = userinfo_birth;
    }

    public String getUserinfo_qq() {
        return userinfo_qq;
    }

    public void setUserinfo_qq(String userinfo_qq) {
        this.userinfo_qq = userinfo_qq;
    }

    public String getUserinfo_prof() {
        return userinfo_prof;
    }

    public void setUserinfo_prof(String userinfo_prof) {
        this.userinfo_prof = userinfo_prof;
    }

    public String getUserinfo_flag() {
        return userinfo_flag;
    }

    public void setUserinfo_flag(String userinfo_flag) {
        this.userinfo_flag = userinfo_flag;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
