package com.example.midtronicsevaluation.Model;

public class Country{

    private String capital;
    private String population;
    private String area;
    private String region;
    private String subregion;


    public Country(String capital, String population, String area, String region, String subRegion){
        this.capital = capital;
        this.subregion = subRegion;
        this.population = population;
        this.area = area;
        this.region = region;
    }

    public String getArea() {
        return area;
    }
    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public String getSubRegion() {
        return subregion;
    }
}
