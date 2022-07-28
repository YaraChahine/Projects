package com.example.technewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.technewsapp" ;
    ArrayList myArray;
    int k = 0;
    SQLiteDatabase ArticlesDB;
    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            myArray = new ArrayList();
            try {
                JSONArray arr = new JSONArray(s);
                for (int i = 0; i < 30; i++) {
                    myArray.add(arr.get(i));
                }
                int i=0;
                while(i<=25) {
                    DownloadTask2 task2 = new DownloadTask2();
                    task2.execute("https://hacker-news.firebaseio.com/v0/item/" + myArray.get(i) + ".json?print=pretty");
                    i++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        public class DownloadTask2 extends AsyncTask<String, Void, String> {

            protected String doInBackground(String... urls) {
                String result = "";
                URL url;
                HttpURLConnection urlConnection;
                try {
                    url = new URL(urls[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in);
                    int data = reader.read();

                    while (data != -1) {
                        char current = (char) data;
                        result += current;
                        data = reader.read();
                    }

                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    JSONObject json = new JSONObject(s);
                    if(json.has("url")) {
                        String url = json.getString("url");
                        String title = json.getString("title");
                        String tempo = String.valueOf(myArray.get(k));
                        ArticlesDB.execSQL("INSERT INTO articles VALUES('" + tempo + "','" + title + "','" + url + "');");
                        k++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Articles will be available soon. Press them to view.", Toast.LENGTH_LONG).show();
        DownloadTask task = new DownloadTask();
        String apiURL = "https://hacker-news.firebaseio.com/v0/topstories.json";
        task.execute(apiURL);
        try {
            ArticlesDB = this.openOrCreateDatabase("ArticlesDB", MODE_PRIVATE, null);
            ArticlesDB.execSQL("CREATE TABLE IF NOT EXISTS articles(article_ID VARCHAR, article_title VARCHAR, article_url VARCHAR)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runnable r = new Runnable() {
            @Override
            public void run(){
                ListView myListView = (ListView) findViewById(R.id.listview);
                ArrayList<String> titles = new ArrayList<String>();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, titles);
                Cursor c1 = ArticlesDB.rawQuery("Select article_title from articles", null);
                int tmp4 = c1.getColumnIndex("article_title");
                c1.moveToFirst();
                int r=0;
                while (c1 != null && r<=20) {
                    String temp= c1.getString(tmp4);
                    titles.add(temp);
                    r++;
                    c1.moveToNext();
                }
                myListView.setAdapter(adapter);
                myListView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Cursor c2 = ArticlesDB.rawQuery("Select article_url from articles Where article_title='" + titles.get(i) + "'", null);
                        String temp="";
                        if(c2!=null)
                        {
                            c2.moveToFirst();
                            do {
                                temp = c2.getString(0);
                            } while (c2.moveToNext());
                        }
                        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                        intent.putExtra(EXTRA_MESSAGE,temp);
                        startActivity(intent);
                    }
                });
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 8000);
    }

}