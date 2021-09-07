package com.cookandroid.finalreport;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BackActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button start, stop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_activity);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true); //toolbar에 뒤로가기 버튼 만듬
        getSupportActionBar().setTitle("등 운동 루틴"); //toolbar의 문자를 등 운동 루틴으로 띄움

        chronometer = findViewById(R.id.clock);
        start = findViewById(R.id.start2);
        stop = findViewById(R.id.stop);
    }

    public void Clickstart (View v) { //시작 버튼을 누르면 chronometer가 시작됨
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometer.setTextColor(Color.RED);
    }

    public void Clickstop (View v) { // 정지 버튼을 누르면 chronometer가 정지됨
        chronometer.stop();
        chronometer.setTextColor(Color.BLUE);
    }

    public void CloseBtnClick(View v) {
        finish();
    }
}
