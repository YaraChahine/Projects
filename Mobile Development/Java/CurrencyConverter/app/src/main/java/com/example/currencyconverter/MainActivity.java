package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   }
        public void convert(View view){
            EditText USD=(EditText) findViewById(R.id.TextOfDollarAmount);
            EditText LBP=(EditText) findViewById(R.id.TextOfLBPAmount);
            TextView text = (TextView) findViewById(R.id.RateAndConverted);
            CheckBox box1=(CheckBox)findViewById(R.id.LBP_Checkbox);
            CheckBox box2=(CheckBox)findViewById(R.id.USD_Checkbox);
            if(box1.isChecked() && !box2.isChecked() ) {
                String value1 = USD.getText().toString();
                int intVal1=Integer.parseInt(value1);
                int convertedToLBP = intVal1*15000;
                text.setText(String.valueOf(convertedToLBP)+"L.L.");
                Toast toast = Toast.makeText(getApplicationContext(),"Converted to LBP", Toast.LENGTH_LONG);
                toast.show();
            }
            if(!box1.isChecked() && box2.isChecked()) {
                String value2 = LBP.getText().toString();
                int intVal2=Integer.parseInt(value2);
                float convertedToUSD = (float) intVal2/15000;
                text.setText("$"+String.valueOf(convertedToUSD));
                Toast toast = Toast.makeText(getApplicationContext(),"Converted to USD", Toast.LENGTH_LONG);
                toast.show();
            }
            if(box1.isChecked() && box2.isChecked()) {
                text.setText("Only 1 box should be checked!");
            }
            if(!box1.isChecked() && !box2.isChecked()) {
                text.setText("Please check a checkbox.");
            }
        }
    }



