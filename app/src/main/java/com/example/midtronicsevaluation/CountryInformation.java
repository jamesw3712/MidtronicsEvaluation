package com.example.midtronicsevaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.midtronicsevaluation.Model.Country;

import org.w3c.dom.Text;

import java.text.NumberFormat;
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
                Country country = getCountry(countryTitle.getText().toString(), response.body());
                if (country == null){
                    handleError();
                    return;
                }
                loadInformationInToUI(country);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText( getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadInformationInToUI(Country country){
        capitalValue.setText(country.getCapital());
        population.setText(NumberFormat.getInstance().format(country.getPopulation()));
        area.setText(NumberFormat.getInstance().format(country.getArea()));
        region.setText(country.getRegion());
        subRegion.setText(country.getSubRegion());

        if (country.getCapital().equals("") || country.getCapital() == null){
            capitalValue.setText("Unavailable");
        }
        if (country.getArea().equals("") || country.getCapital() == null){
            capitalValue.setText("Unavailable");
        }
        if (country.getPopulation().equals("") || country.getCapital() == null){
            capitalValue.setText("Unavailable");
        }
        if (country.getRegion().equals("") || country.getCapital() == null){
            capitalValue.setText("Unavailable");
        }
        if (country.getSubRegion().equals("") || country.getCapital() == null){
            capitalValue.setText("Unavailable");
        }
    }

    private void handleError(){
        capitalValue.setText("Unavailable");
        population.setText("Unavailable");
        area.setText("Unavailable");
        region.setText("Unavailable");
        subRegion.setText("Unavailable");
        Toast.makeText(getApplicationContext(),"failed to get country", Toast.LENGTH_SHORT).show();
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
