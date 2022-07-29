package com.example.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String selected_language;
    TextView result;
    Random rand = new Random();
    int random_number;
    TextView percentage;
    ListView listview;
    ArrayList<String> languages_array;
    ArrayAdapter<String> adapter;
    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        percentage= (TextView) findViewById(R.id.percentage);
        img= (ImageView) findViewById(R.id.img);



        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Java");
        categories.add("Python");
        categories.add("C#");
        categories.add("C++");
        categories.add("C");
        categories.add("Swift");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        listview= (ListView) findViewById(R.id.listview);
        languages_array =new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,languages_array);

        img.setImageDrawable(null);


    }

        @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selected_language = adapterView.getItemAtPosition(i).toString();

        }

        public void Calculate(View view){
            random_number = rand.nextInt(100);
            Integer random_percentage= new Integer(random_number);
            String random=random_percentage.toString()+ " %";
            percentage.setText(random_number+"%");

            if (selected_language.equalsIgnoreCase("Java")) {
                img.setX(-900);
                img.setImageResource(R.drawable.java);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }
            else if (selected_language.equalsIgnoreCase("Swift")) {
                img.setX(-900);
                img.setImageResource(R.drawable.swift);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }
            else if (selected_language.equalsIgnoreCase("Python")) {
                img.setX(-900);
                img.setImageResource(R.drawable.python);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }

            else if (selected_language.equalsIgnoreCase("C")) {
                img.setX(-900);
                img.setImageResource(R.drawable.cc);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }

            else if (selected_language.equalsIgnoreCase("C++")) {
                img.setX(-900);
                img.setImageResource(R.drawable.cpp);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }

            else if (selected_language.equalsIgnoreCase("C#")) {
                img.setX(-900);
                img.setImageResource(R.drawable.csharp);
                img.animate().translationXBy(1000).rotation(3600).setDuration(1000);
            }


            if (selected_language.length()<4){
                while (selected_language.length()<5){
                    selected_language=selected_language+"   ";
                }
            }
            languages_array.add(selected_language+"                                                           "+random);
            listview.setAdapter(adapter);


        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}