package com.example.importify.Model;

import java.io.Serializable;

public class CountryConstituent implements Serializable {

    private int year;
    private String constituent;
    private double value;

    public CountryConstituent(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getConstituent() {
        return constituent;
    }

    public void setConstituent(String constituent) {
        this.constituent = constituent;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
