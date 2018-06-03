package com.lhz.model;

import java.sql.Timestamp;

public class Relation {

    private int relation_id;
    private Timestamp relation_time;
    private String relation_type;
    private String relation_groupname;
    private String user_id;
    private String user_byid;

    public int getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }

    public Timestamp getRelation_time() {
        return relation_time;
    }

    public void setRelation_time(Timestamp relation_time) {
        this.relation_time = relation_time;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }

    public String getRelation_groupname() {
        return relation_groupname;
    }

    public void setRelation_groupname(String relation_groupname) {
        this.relation_groupname = relation_groupname;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_byid() {
        return user_byid;
    }

    public void setUser_byid(String user_byid) {
        this.user_byid = user_byid;
    }
}
