package com.barisd.java12test.JUNIT_TEST;


import java.io.Serializable;


public class User implements Serializable {
    String ad;
    Integer yas;

    public User(String ad, Integer yas) {
        this.ad = ad;
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "User{" +
                "ad='" + ad + '\'' +
                ", yas=" + yas +
                '}';
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public Integer getYas() {
        return yas;
    }
}
