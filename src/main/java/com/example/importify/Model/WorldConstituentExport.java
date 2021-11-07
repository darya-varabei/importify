package com.example.importify.Model;

import java.io.Serializable;

public class WorldConstituentExport implements Serializable {
    private int year;
    private double value;

    public WorldConstituentExport(){}

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
