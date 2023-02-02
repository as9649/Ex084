package com.example.ex084;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomSpinner extends BaseAdapter {
    Context context;
    String[] countries;
    String[] capitalCities;
    int[] flags;
    LayoutInflater inflter;

    public CustomSpinner(Context applicationContext, String[] countries, String[] capitalCities, int[] flags) {
        this.context = applicationContext;
        this.countries = countries;
        this.capitalCities=capitalCities;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner, null);
        TextView country = (TextView) view.findViewById(R.id.tV);
        TextView city = (TextView) view.findViewById(R.id.tV2);
        ImageView flag = (ImageView) view.findViewById(R.id.iV);
        country.setText(countries[i]);
        city.setText(capitalCities[i]);
        flag.setImageResource(flags[i]);
        return view;
    }

}


