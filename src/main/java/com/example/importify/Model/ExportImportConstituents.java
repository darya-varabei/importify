package com.example.importify.Model;

import java.io.Serializable;

public class ExportImportConstituents implements Serializable {
    private int year;
    private String constituent;
    private double exportValue;
    private double importValue;

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

    public void setRole(String netExportValue) {
        this.constituent = constituent;
    }
}
