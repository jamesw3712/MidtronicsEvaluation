package com.example.midtronicsevaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.midtronicsevaluation.Model.Country;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryInformation extends AppCompatActivity {

    TextView countryTitle;
    TextView capitalValue;
    TextView population;
    TextView area;
    TextView region;
    TextView subRegion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);


        countryTitle = findViewById(R.id.countryTitle);
        capitalValue = findViewById(R.id.capitalValue);
        population = findViewById(R.id.populationValue);
        area = findViewById(R.id.areaValue);
        region = findViewById(R.id.regionValue);
        subRegion = findViewById(R.id.subRegionValue);

        countryTitle.setText(getIntent().getStringExtra("countryName"));
        displayCountryInformation();
    }


    private void displayCountryInformation(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        Call<List<Country>> call = api.getCountryInfo(countryTitle.getText().toString());

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                loadInformationInToUI(response.body().get(0));
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText( getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadInformationInToUI(Country country){
        capitalValue.setText(country.getCapital());
        population.setText(country.getPopulation());
        area.setText(country.getArea());
        region.setText(country.getRegion());
        subRegion.setText(country.getSubRegion());
    }
}
