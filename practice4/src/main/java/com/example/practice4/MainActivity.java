package com.example.practice4;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        final Run1 runn1 = new Run1(tvInfo);
        final Runnable runn2 = new Runnable() {
            public void run() {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("KEY", "runn2");
                msg.setData(bundle);
                if (runn1 != null) {
                    runn1.handler.sendMessage(msg);
                }
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                tvInfo.setText("runn3");
            }
        };
        new Thread(new Runnable() {
            public void run() {
                try {
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    tvInfo.postDelayed(runn3, 2000);
                    tvInfo.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}