package com.example.importify.Model;

import java.io.Serializable;

public class WorldShare implements Serializable {
    private String country;
    private double share;

    public WorldShare(){}

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
