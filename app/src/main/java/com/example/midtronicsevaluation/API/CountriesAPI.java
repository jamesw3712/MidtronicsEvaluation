package com.example.midtronicsevaluation.API;

import com.example.midtronicsevaluation.Model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesAPI {

    private ApiResult resultCallback;

    public CountriesAPI(ApiResult resultCallback){
        this.resultCallback = resultCallback;
    }

    public void getCountry(final String countryTitle){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Call<List<Country>> call = api.getCountryInfo(countryTitle);

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                Country country = getCountry(countryTitle, response.body());
                if (country == null){
                    resultCallback.onError();
                    return;
                }
                resultCallback.onAPISuccess(country);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                resultCallback.onError();
            }
        });

    }

    private Country getCountry(String countryName, List<Country> countries){
        if (countries == null){
            return null;
        }
        for (Country country: countries){
            if (country.getName().toLowerCase().equals(countryName.toLowerCase())){
                return country;
            }
        }
        return countries.get(0);
    }

}
