package com.example.importify.Model;

import java.io.Serializable;

public class CategoryShare implements Serializable {
    private String category;
    private double value;

    public CategoryShare(String category, double value) {
        this.category = category;
        this.value = value;
    }

    public void setCategory(String category) { this.category = category; }

    public String getCategory() { return this.category; }

    public void setValue(double value) { this.value = value; }

    public double getValue() { return this.value; }
}
