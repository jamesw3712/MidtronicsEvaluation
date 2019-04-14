package com.example.midtronicsevaluation.Model;

public class Country{

    private String capital;
    private int population;
    private float area;
    private String region;
    private String subregion;
    private String name;


    public Country(String capital, int population, float area, String region, String subRegion, String name){
        this.capital = capital;
        this.subregion = subRegion;
        this.population = population;
        this.area = area;
        this.region = region;
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getSubRegion() {
        return subregion;
    }
}
