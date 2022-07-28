package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayList<String> nums =new ArrayList<String>(Arrays.asList("","","","","","","","","",""));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nums);
        seekBar.setMax(20);
        listView.setAdapter(adapter);
        Toast toast = Toast.makeText(getApplicationContext(),"Move the seekbar to see the Multiplication tables of numbers 1 to 20", Toast.LENGTH_LONG);
        toast.show();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(seekBar.getProgress()==0){
                    seekBar.setProgress(1);
                    i=1;
                }
                for(int j=0;j<nums.size();j++){
                    String newNum = "  " + Integer.toString(i)+ " x " + Integer.toString(j+1)  + " = " + Integer.toString(i*(j+1));
                    nums.set(j,newNum);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}