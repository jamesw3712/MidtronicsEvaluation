package com.example.midtronicsevaluation.Model;

public class Country{

    private String capital;
    private Integer population;
    private Integer area;
    private String region;
    private String subregion;
    private String name;


    public Country(String capital, Integer population, Integer area, String region, String subRegion, String name){
        this.capital = capital;
        this.subregion = subRegion;
        this.population = population;
        this.area = area;
        this.region = region;
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public Integer getPopulation() {
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
