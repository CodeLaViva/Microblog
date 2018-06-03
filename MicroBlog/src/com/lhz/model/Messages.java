package com.lhz.model;

import java.sql.Timestamp;

public class Messages {
    private int messages_id;
    private String messages_type;
    private String messages_info;
    private Timestamp messages_time;
    private int messages_commentnum;
    private int messages_agreement;
    private int messages_collection;
    private String messages_label;
    private String user_id;

    public int getMessages_id() {
        return messages_id;
    }

    public void setMessages_id(int messages_id) {
        this.messages_id = messages_id;
    }

    public String getMessages_type() {
        return messages_type;
    }

    public void setMessages_type(String messages_type) {
        this.messages_type = messages_type;
    }

    public String getMessages_info() {
        return messages_info;
    }

    public void setMessages_info(String messages_info) {
        this.messages_info = messages_info;
    }

    public Timestamp getMessages_time() {
        return messages_time;
    }

    public void setMessages_time(Timestamp messages_time) {
        this.messages_time = messages_time;
    }

    public int getMessages_commentnum() {
        return messages_commentnum;
    }

    public void setMessages_commentnum(int messages_commentnum) {
        this.messages_commentnum = messages_commentnum;
    }

    public int getMessages_agreement() {
        return messages_agreement;
    }

    public void setMessages_agreement(int messages_agreement) {
        this.messages_agreement = messages_agreement;
    }

    public int getMessages_collection() {
        return messages_collection;
    }

    public void setMessages_collection(int messages_collection) {
        this.messages_collection = messages_collection;
    }

    public String getMessages_label() {
        return messages_label;
    }

    public void setMessages_label(String messages_label) {
        this.messages_label = messages_label;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
