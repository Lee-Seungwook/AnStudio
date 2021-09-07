package com.cookandroid.exam3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView subTxt;
    private final String LOG_TAG = "LifeSubActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        subTxt = findViewById(R.id.subTxt);

        Intent intent = getIntent();
        subTxt.setText(intent.getStringExtra(Intent.EXTRA_TEXT));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");

        Log.d(LOG_TAG, "_______");
        Log.d(LOG_TAG, "onCreate");
    }

    public void CloseBtnClick(View v) {
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG,"onResume");
    }
}

