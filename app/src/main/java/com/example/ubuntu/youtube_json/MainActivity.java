package com.example.ubuntu.youtube_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//https://api.myjson.com/bins/w92v8
public class MainActivity extends AppCompatActivity {

    Button button;
   static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        textView = findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FetchData fetchData = new FetchData();
            fetchData.execute();
            }
        });
    }
}
