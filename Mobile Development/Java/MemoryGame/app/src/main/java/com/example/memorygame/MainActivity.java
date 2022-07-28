package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[] images;
    List<Integer> tags=new ArrayList<Integer>();
    int[] temp={0,0};
    ImageView clicked1;
    ImageView clicked2;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    TextView myScore;
    TextView winningText;
    androidx.gridlayout.widget.GridLayout myGrid;
    Button myButton;
    int clicks=0;
    int score=0;
    public void dropIn(View view) {
        clicks++;
        if (clicks == 1) {
            clicked1 = (ImageView) view;
            int tag = Integer.parseInt(clicked1.getTag().toString());
            clicked1.animate().rotation(clicked1.getRotation() + 360).setDuration(300);
            clicked1.setImageResource(images[tag]);
            temp[0] = images[tag];
            tags.add(tag);
        }
        if (clicks == 2) {
            clicked2 = (ImageView) view;
            int tag = Integer.parseInt(clicked2.getTag().toString());
            clicked2.animate().rotation(clicked2.getRotation() + 360).setDuration(300);
            clicked2.setImageResource(images[tag]);
            temp[1] = images[tag];
            tags.add(tag);
            if (temp[0] == temp[1] && tags.get(0) != tags.get(1)) {
                int[] temp = {0, 0};
                clicks = 0;
                score++;
                tags.clear();
                myScore.setText("Score: " + score);
                Toast toast = Toast.makeText(getApplicationContext(), "Great job! They match.", Toast.LENGTH_SHORT);
                toast.show();
        } else if (temp[0] != temp[1]) {
            new CountDownTimer(500, 100) {
                @Override
                public void onTick(long l) {
                }

                @Override
                public void onFinish() {
                    clicked1.animate().rotation(clicked1.getRotation() + 360).setDuration(300);
                    clicked1.setImageResource(R.drawable.back_image);
                    clicked2.animate().rotation(clicked2.getRotation() + 360).setDuration(300);
                    clicked2.setImageResource(R.drawable.back_image);
                    int[] temp = {0, 0};
                    clicks = 0;
                    tags.clear();
                }
            }.start();
            }
        }
            if (score == 4) {
                winningText.setVisibility(View.VISIBLE);
                myGrid.setVisibility(View.INVISIBLE);
            }
    }
    public void play(View view){
        myGrid.setVisibility(View.VISIBLE);
        Random rand = new Random();
        if (myButton.getText()=="Play Again"){
            score=0;
            myScore.setText("Score: " + score);
            imageView1.setImageResource(R.drawable.back_image);
            imageView2.setImageResource(R.drawable.back_image);
            imageView3.setImageResource(R.drawable.back_image);
            imageView4.setImageResource(R.drawable.back_image);
            imageView5.setImageResource(R.drawable.back_image);
            imageView6.setImageResource(R.drawable.back_image);
            imageView7.setImageResource(R.drawable.back_image);
            imageView8.setImageResource(R.drawable.back_image);
            imageView1.setRotation(0);
            imageView2.setRotation(0);
            imageView3.setRotation(0);
            imageView4.setRotation(0);
            imageView5.setRotation(0);
            imageView6.setRotation(0);
            imageView7.setRotation(0);
            imageView8.setRotation(0);

        }
        images = new int[]{R.drawable.image1, R.drawable.image1, R.drawable.image2, R.drawable.image2, R.drawable.image3, R.drawable.image3, R.drawable.image4, R.drawable.image4};
        for (int i = 0; i < images.length; i++) {
            int randomIndex = rand.nextInt(images.length);
            int temp = images[randomIndex];
            images[randomIndex] = images[i];
            images[i] = temp;
        }
        myButton.setText("Play Again");
        winningText.setVisibility(View.INVISIBLE);
        clicks=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myScore = (TextView) findViewById(R.id.Score);
        myButton = (Button) findViewById(R.id.button);
        myGrid = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);
        winningText = (TextView) findViewById(R.id.congrats);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
    }
}