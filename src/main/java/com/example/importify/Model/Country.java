package com.example.importify.Model;

import javafx.scene.image.Image;

public class Country {
    private String id;
    private String name;
    private double area;
    private int population;

    public void setId(String id) { this.id = id; }

    public String getId() { return this.id; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public void setArea(double area) { this.area = area; }

    public double getArea() { return this.area; }

    public void setPopulation(int population) { this.population = population; }

    public int getPopulation() { return this.population; }
}
