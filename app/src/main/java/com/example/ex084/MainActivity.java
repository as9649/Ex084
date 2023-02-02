package com.example.ex084;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView textView;
    String[] countries={"Israel", "Argentina", "Brazil", "France", "Portugal", "Germany", "Spain"};
    int[] flags={R.drawable.israel, R.drawable.argentina, R.drawable.brazil, R.drawable.france,
            R.drawable.portugal, R.drawable.germany, R.drawable.spain};
    String[] capitalCities={"Jerusalem", "Buenos Aires", "Brasilia", "Paris", "Lisbon", "Berlin", "Madrid"};
    int[] population={1,2,3,4,5,6,7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        textView=findViewById(R.id.textView);
        CustomSpinner customadp = new CustomSpinner(this, countries, capitalCities, flags);
        spinner.setAdapter(customadp);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        textView.setText(countries[i]+"\n"+capitalCities[i]+"\n"+population[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}