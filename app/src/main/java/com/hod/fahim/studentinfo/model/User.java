package com.hod.fahim.studentinfo.model;

public class User {

    private String uid,pname,p_place,p_price;


    public User(){
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getP_place() {
        return p_place;
    }

    public void setP_place(String p_place) {
        this.p_place = p_place;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public User(String uid, String pname, String p_place, String p_price) {
        this.uid = uid;
        this.pname = pname;
        this.p_place = p_place;
        this.p_price = p_price;
    }
}
