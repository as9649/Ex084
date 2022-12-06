package com.example.ex084;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
class CustomSpinner extends BaseAdapter{
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