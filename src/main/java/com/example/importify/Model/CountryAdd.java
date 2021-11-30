package com.example.importify.Model;

import java.io.Serializable;

public class CountryAdd implements Serializable {
    private String country;
    private double exportValue;
    private double importValue;
    private double netExportValue;

    public CountryAdd(String country, double exportValue, double importValue, double netExportValue){
        this.country = country;
        this.exportValue = exportValue;
        this.importValue = importValue;
        this.netExportValue = netExportValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getExportValue() {
        return exportValue;
    }

    public void setExportValue(double exportValue) {
        this.exportValue = exportValue;
    }

    public double getImportValue() {
        return importValue;
    }

    public void setImportValue(double importValue) {
        this.importValue = importValue;
    }

    public double getNetExportValue() {
        return netExportValue;
    }

    public void setRole(double netExportValue) {
        this.netExportValue = netExportValue;
    }
}

