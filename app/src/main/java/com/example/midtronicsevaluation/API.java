package com.example.midtronicsevaluation;

import com.example.midtronicsevaluation.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    String BASE_URL = "https://restcountries.eu/rest/v1/name/";

    @GET("{countryName}")
    Call<List<Country>> getCountryInfo(@Path("countryName") String countryName);
}
