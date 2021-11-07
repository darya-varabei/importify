package com.example.importify.Model;

import java.io.Serializable;

public class CountryImportExport implements Serializable {
    private int year;
    private double exportValue;
    private double importValue;
    private double netExportValue;

    public CountryImportExport(){}

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

    public double getNetExportValue() {
        return netExportValue;
    }

    public void setRole(double netExportValue) {
        this.netExportValue = netExportValue;
    }
}
