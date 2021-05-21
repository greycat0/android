package com.example.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public TextView timeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timeLabel = findViewById(R.id.time);

        Intent intent = getIntent();
        String time = intent.getStringExtra("time");
        timeLabel.setText(time);
    }
}