package com.example.sleeptight;

import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class Morning implements Serializable {
    private String date;

    private String sleeptime;

    private String getuptime;

    private int sleepstress;

    private int hardtosleep;

    private int howsleep;

    private int cannotsleep;

    private int prematurely;

    private int awaken;

    public Morning() {

    }

    public Morning(String date, String sleeptime, String getuptime, int sleepstress, int hardtosleep, int howsleep, int cannotsleep, int prematurely, int awaken) {
        this.date = date;
        this.sleeptime = sleeptime;
        this.getuptime = getuptime;
        this.sleepstress = sleepstress;
        this.hardtosleep = hardtosleep;
        this.howsleep = howsleep;
        this.cannotsleep = cannotsleep;
        this.prematurely = prematurely;
        this.awaken = awaken;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSleeptime() {
        return sleeptime;
    }

    public void setSleeptime(String sleeptime) {
        this.sleeptime = sleeptime;
    }

    public String getGetuptime() {
        return getuptime;
    }

    public void setGetuptime(String getuptime) {
        this.getuptime = getuptime;
    }

    public int getSleepstress() {
        return sleepstress;
    }

    public void setSleepstress(int sleepstress) {
        this.sleepstress = sleepstress;
    }

    public int getHardtosleep() {
        return hardtosleep;
    }

    public void setHardtosleep(int hardtosleep) {
        this.hardtosleep = hardtosleep;
    }

    public int getHowsleep() {
        return howsleep;
    }

    public void setHowsleep(int howsleep) {
        this.howsleep = howsleep;
    }

    public int getCannotsleep() {
        return cannotsleep;
    }

    public void setCannotsleep(int cannotsleep) {
        this.cannotsleep = cannotsleep;
    }

    public int getAwaken() {
        return awaken;
    }

    public void setAwaken(int awaken) {
        this.awaken = awaken;
    }

    public int getPrematurely() {
        return prematurely;
    }

    public void setPrematurely(int prematurely) {
        this.prematurely = prematurely;
    }
}
