package com.example.midtronicsevaluation.CountryListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtronicsevaluation.CountryInformationActivity.CountryInformation;
import com.example.midtronicsevaluation.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountriesFragment extends Fragment {

    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.countries_fragment, container,false);

        recyclerView = view.findViewById(R.id.countriesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CountriesAdapter adapter = new CountriesAdapter(getCountries());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(String countryClicked) {
                handleCountryClicked(countryClicked);
            }
        });

        return view;
    }

    private void handleCountryClicked(String countryName){
        Intent i = new Intent(getActivity(), CountryInformation.class);
        i.putExtra("countryName", countryName);
        startActivity(i);
    }

    private ArrayList<String> getCountries(){
        String [] countries = getResources().getStringArray(R.array.countries_array);
        ArrayList<String> sortedCountries =  new ArrayList( Arrays.asList(countries) );
        Collections.sort(sortedCountries);
        return sortedCountries;
    }


}
