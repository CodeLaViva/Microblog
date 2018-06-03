package com.lhz.model;
import java.sql.Timestamp;

public class Comments {

    private int comments_id;
    private String comments_info;
    private Timestamp comments_time;
    private int messages_id;
    private String user_id;

    public int getComments_id() {
        return comments_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public String getComments_info() {
        return comments_info;
    }

    public void setComments_info(String comments_info) {
        this.comments_info = comments_info;
    }

    public Timestamp getComments_time() {
        return comments_time;
    }

    public void setComments_time(Timestamp comments_time) {
        this.comments_time = comments_time;
    }

    public int getMessages_id() {
        return messages_id;
    }

    public void setMessages_id(int messages_id) {
        this.messages_id = messages_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
