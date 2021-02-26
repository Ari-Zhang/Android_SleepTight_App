package com.example.tests;

import java.io.Serializable;

public class Test implements Serializable {
    String date;
    String Secondtrialtime;
    String Thirdtrialtime;
    String result;

    public Test(String date, String secondtrialtime, String thirdtrialtime, String result) {
        this.date = date;
        Secondtrialtime = secondtrialtime;
        Thirdtrialtime = thirdtrialtime;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecondtrialtime() {
        return Secondtrialtime;
    }

    public void setSecondtrialtime(String secondtrialtime) {
        Secondtrialtime = secondtrialtime;
    }

    public String getThirdtrialtime() {
        return Thirdtrialtime;
    }

    public void setThirdtrialtime(String thirdtrialtime) {
        Thirdtrialtime = thirdtrialtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
