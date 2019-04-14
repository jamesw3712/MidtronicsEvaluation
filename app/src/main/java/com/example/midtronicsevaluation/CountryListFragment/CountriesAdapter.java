package com.example.midtronicsevaluation.CountryListFragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.midtronicsevaluation.R;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryCell> {

    private ArrayList<String> countries;
    private ClickListener clickListener;

    public CountriesAdapter(ArrayList<String> countries) {
        this.countries = countries;
    }

    @Override
    public CountriesAdapter.CountryCell onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.country_cell, parent, false);
        CountryCell item = new CountryCell(row);
        return item;
    }

    @Override
    public void onBindViewHolder(CountryCell holder, int position) {
        holder.countryTextView.setText(countries.get(position));
        if(position%2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#333333"));
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class CountryCell extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView countryTextView;

        public CountryCell(View v) {
            super(v);
            countryTextView = v.findViewById(R.id.countryName);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(countryTextView.getText().toString());
        }
    }
}