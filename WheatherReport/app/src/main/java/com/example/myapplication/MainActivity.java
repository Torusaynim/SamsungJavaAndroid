package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDownload md = new MyDownload();
                md.execute();
                //логика вызова AsyncTask
            }
        });
    } //close onCreate()

    private class MyDownload extends AsyncTask<Void,Void,String> {

        HttpURLConnection httpurl;

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://api.weatherstack.com/current?access_key=69c678a9192730b34eacde30c1e98d87&query=Moscow");
                httpurl = (HttpURLConnection) url.openConnection();
                httpurl.setRequestMethod("GET");
                httpurl.connect();

                InputStream inputstream = httpurl.getInputStream();
                Scanner scan = new Scanner(inputstream);
                StringBuffer buffer = new StringBuffer();
                while (scan.hasNextLine()) {
                    buffer.append(scan.nextLine());
                }
                return buffer.toString();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}
