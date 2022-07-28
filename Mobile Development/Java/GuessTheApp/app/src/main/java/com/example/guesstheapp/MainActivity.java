package com.example.guesstheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    ArrayList<String> appNames;
    ArrayList<String> images;
    ArrayList<String> currentAnswers = new ArrayList<String>(4);
    Bitmap downloadedImg;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView attemptsText;
    TextView scoreText;
    int score = 0;
    Button buttonPressed;
    int locationOfCorrectAnswer;
    int wrongAnswerIndex;
    int turn = 0;
    DownloadTask task;
    ImageDownloader imageTask;
    String result;
    int attempts;
    String level;
    TextView TimerText;
    CountDownTimer timer;
    public static ArrayList<String> parseNames(String s){
        ArrayList<String> names = new ArrayList<String>();
        Pattern p = Pattern.compile("g\" alt=\"(?!Jeffrey)(?!Gabriel)(.*?) Image\"");
        Matcher m = p.matcher(s);
        while(m.find()){
            names.add(m.group(1));
        }
        return names;
    }

    public static ArrayList<String> parseImages(String s){
        ArrayList<String> images = new ArrayList<String>();
        Pattern p = Pattern.compile("data-image-loader=\"(.*?)\" alt=");
        Matcher m = p.matcher(s);
        while(m.find()){
            images.add(m.group(1));
        }
        return images;
    }
    public void downloadImage(){
        imageTask = new ImageDownloader();
        try {
            downloadedImg = imageTask.execute(images.get(turn)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        imgView.setImageBitmap(downloadedImg);
    }
    public void next(View view){
        buttonPressed = (Button) findViewById(view.getId());
        attemptsText = (TextView) findViewById(R.id.attemptsText);
        scoreText = (TextView) findViewById(R.id.score);
        if(attempts==1 && buttonPressed.getText()!=appNames.get(turn)){
            button = (Button) findViewById(R.id.button);
            button1 = (Button) findViewById(R.id.button1);
            button2 = (Button) findViewById(R.id.button2);
            button3 = (Button) findViewById(R.id.button3);
            button4 = (Button) findViewById(R.id.button4);
            attemptsText.setText("You lost.");
            imgView.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
            TimerText.setText("");
        }

        if(turn==102 && buttonPressed.getText()==appNames.get(turn)){
            button = (Button) findViewById(R.id.button);
            button1 = (Button) findViewById(R.id.button1);
            button2 = (Button) findViewById(R.id.button2);
            button3 = (Button) findViewById(R.id.button3);
            button4 = (Button) findViewById(R.id.button4);
            attemptsText.setText("You won!");
            imgView.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
        }
        else if(buttonPressed.getText()==appNames.get(turn)){
             Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
             turn++;
             downloadImage();
             getChoice();
             score+=2;
        }else if(buttonPressed.getText()!=appNames.get(turn)){
            Toast.makeText(getApplicationContext(),"Incorrect.",Toast.LENGTH_SHORT).show();
            score--;
            attempts--;
            if(attempts>1) {
                attemptsText.setText("You have " + attempts + " attempts left.");
            }
            else{
                attemptsText.setText("You have " + attempts + " attempt left.");
            }
        }
        switch (level){
            case("Easy"):
                break;
            case("Medium"):
                scoreText.setText("Score: " + score);
                break;
            case("Hard"):
                scoreText.setText("Score: " + score);
                if(attempts==1 && buttonPressed.getText()!=appNames.get(turn)) {
                    timer.cancel();
                }
                break;
        }
    }

    public void backToMain(View view){
        button = (Button) findViewById(R.id.button);
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void getChoice(){
        Random rand = new Random();
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        locationOfCorrectAnswer = rand.nextInt(4);
        currentAnswers.clear();
        for(int i=0; i<4; i++){
            if(i==locationOfCorrectAnswer){
                currentAnswers.add(appNames.get(turn));
            }else{
                wrongAnswerIndex = rand.nextInt(103);
                while(currentAnswers.contains(appNames.get(wrongAnswerIndex))){
                    wrongAnswerIndex = rand.nextInt(103);
                }
                currentAnswers.add(appNames.get(wrongAnswerIndex));
            }
        }
        button1.setText(currentAnswers.get(0));
        button2.setText(currentAnswers.get(1));
        button3.setText(currentAnswers.get(2));
        button4.setText(currentAnswers.get(3));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attemptsText = (TextView) findViewById(R.id.attemptsText);
        TimerText = (TextView) findViewById(R.id.TimerText);
        scoreText = (TextView) findViewById(R.id.score);
        imgView = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        level = intent.getStringExtra(Home.EXTRA_MESSAGE);
        switch (level){
            case("Easy"):
                attemptsText.setText("You have 15 attempts.");
                scoreText.setVisibility(View.INVISIBLE);
                TimerText.setVisibility(View.INVISIBLE);
                attempts=15;
                break;
            case("Medium"):
                attemptsText.setText("You have 10 attempts.");
                scoreText.setText("Score: " + score);
                TimerText.setVisibility(View.INVISIBLE);
                attempts=10;
                break;
            case("Hard"):
                attemptsText.setText("You have 5 attempt.");
                TimerText.setText("Time left: 120 seconds");
                scoreText.setText("Score: " + score);
                attempts=5;
                timer = new CountDownTimer(120000, 1000){
                    @Override
                    public void onTick(long l) {
                        TimerText.setText("Time left:" + String.valueOf(l/1000) + " seconds");
                    }

                    @Override
                    public void onFinish() {
                        button = (Button) findViewById(R.id.button);
                        button1 = (Button) findViewById(R.id.button1);
                        button2 = (Button) findViewById(R.id.button2);
                        button3 = (Button) findViewById(R.id.button3);
                        button4 = (Button) findViewById(R.id.button4);
                        attemptsText.setText("Time's up. You lost.");
                        imgView.setVisibility(View.INVISIBLE);
                        button1.setVisibility(View.INVISIBLE);
                        button2.setVisibility(View.INVISIBLE);
                        button3.setVisibility(View.INVISIBLE);
                        button4.setVisibility(View.INVISIBLE);
                        button.setVisibility(View.VISIBLE);

                    }
                }.start();
                break;
        }
        task = new DownloadTask();
        result = null;

        try{
            result = task.execute("https://www.pcmag.com/picks/best-android-apps").get();
            downloadImage();
            getChoice();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... urls){

            try{
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap downloadedImage = BitmapFactory.decodeStream(in);
                return downloadedImage;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String result1 = "";
                while ((result1=reader.readLine())!=null){
                    result.append(result1);
                }
                String newResult = result.toString();
                appNames = parseNames(newResult);
                images = parseImages(newResult);
                appNames.remove(appNames.size()-1);
                appNames.remove(appNames.size()-1);
                appNames.remove(appNames.size()-1);
                appNames.remove(appNames.size()-1);
                images.remove(images.size()-1);
                images.remove(images.size()-1);
                images.remove(images.size()-1);
                images.remove(images.size()-1);
                images.remove(images.size()-1);
                return newResult;
            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }
        }
    }
}