package com.example.importify.Model;

import java.io.Serializable;

public class ExportImportConstituents implements Serializable {
    private int year;
    private String constituent;
    private double exportValue;
    private double importValue;
    private String country;

    public ExportImportConstituents(){}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getConstituent() {
        return constituent;
    }

    public void setConstituent(String netExportValue) {
        this.constituent = constituent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
