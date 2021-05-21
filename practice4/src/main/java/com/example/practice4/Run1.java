package com.example.practice4;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class Run1 extends Thread {
    TextView tvInfo;
    Handler handler;

    public Run1(TextView textView) {
        tvInfo = textView;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        tvInfo.setText("runn1");
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                tvInfo.setText(msg.getData().getString("KEY"));
            }
        };
        Looper.loop();
    }
};
