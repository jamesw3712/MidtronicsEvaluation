package com.example.midtronicsevaluation.CountryInformationActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.midtronicsevaluation.API.ApiResult;
import com.example.midtronicsevaluation.API.CountriesAPI;
import com.example.midtronicsevaluation.Model.Country;
import com.example.midtronicsevaluation.R;

import java.text.NumberFormat;

public class CountryInformation extends AppCompatActivity implements ApiResult {

    private TextView countryTitle;
    private TextView capitalValue;
    private TextView population;
    private TextView area;
    private TextView region;
    private TextView subRegion;
    private CountriesAPI client;

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

        client = new CountriesAPI(this);
        client.getCountry(countryTitle.getText().toString());
    }

    @Override
    public void onAPISuccess(Country country) {
        loadInformationInToUI(country);
    }

    @Override
    public void onError() {
        capitalValue.setText("Unavailable");
        population.setText("Unavailable");
        area.setText("Unavailable");
        region.setText("Unavailable");
        subRegion.setText("Unavailable");
        Toast.makeText(getApplicationContext(),"Country Unavailable", Toast.LENGTH_SHORT).show();
    }

    private void loadInformationInToUI(Country country){
        capitalValue.setText(country.getCapital());
        population.setText(NumberFormat.getInstance().format(country.getPopulation()));
        area.setText(NumberFormat.getInstance().format(country.getArea()));
        region.setText(country.getRegion());
        subRegion.setText(country.getSubRegion());

        if (country.getCapital() == null || country.getCapital().equals("")){
            capitalValue.setText("Unavailable");
        }
        if (country.getArea() == null || country.getArea().equals("")){
            population.setText("Unavailable");
        }
        if (country.getPopulation() == null || country.getPopulation().equals("")){
            area.setText("Unavailable");
        }
        if (country.getRegion() == null || country.getRegion().equals("")){
            region.setText("Unavailable");
        }
        if (country.getSubRegion() == null || country.getSubRegion().equals("")){
            subRegion.setText("Unavailable");
        }
    }
}
