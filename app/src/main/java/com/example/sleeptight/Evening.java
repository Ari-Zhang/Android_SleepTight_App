package com.example.sleeptight;

import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class Evening implements Serializable {

    private String date;
    private String choice;
    private String addon;

    private int healthcondition;
    private int stress;
    private int mentalloading;
    private int tommorowstress;
    private int anxiousnow;

    public Evening(String date, String choice, String addon, int healthcondition, int stress, int mentalloading, int tommorowstress, int anxiousnow) {
        this.date = date;
        this.choice = choice;
        this.addon = addon;
        this.healthcondition = healthcondition;
        this.stress = stress;
        this.mentalloading = mentalloading;
        this.tommorowstress = tommorowstress;
        this.anxiousnow = anxiousnow;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public int getHealthcondition() {
        return healthcondition;
    }

    public void setHealthcondition(int healthcondition) {
        this.healthcondition = healthcondition;
    }

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getMentalloading() {
        return mentalloading;
    }

    public void setMentalloading(int mentalloading) {
        this.mentalloading = mentalloading;
    }

    public int getTommorowstress() {
        return tommorowstress;
    }

    public void setTommorowstress(int tommorowstress) {
        this.tommorowstress = tommorowstress;
    }

    public int getAnxiousnow() {
        return anxiousnow;
    }

    public void setAnxiousnow(int anxiousnow) {
        this.anxiousnow = anxiousnow;
    }
}
