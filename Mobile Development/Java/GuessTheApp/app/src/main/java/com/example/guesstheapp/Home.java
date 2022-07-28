package com.example.guesstheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button buttonClicked;
    Button btn1;
    Button btn2;
    Button btn3;
    public static final String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void startGame(View view){
        buttonClicked = (Button) findViewById(view.getId());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE,buttonClicked.getText());
        startActivity(intent);
    }
}