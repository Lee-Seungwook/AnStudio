package com.cookandroid.example2_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score=0;

    TextView scoreView, scoreBoard;
    Button plusButton, minusButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("score");
        }

        scoreBoard=findViewById(R.id.scoreBoard);

        scoreView=findViewById(R.id.scoreView);
        scoreView.setText(String.valueOf(score));

        plusButton=findViewById(R.id.plusButton);
        minusButton=findViewById(R.id.minusButton);
        resetButton=findViewById(R.id.resetButton);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=1;
                scoreView.setText(String.valueOf(score));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score-=1;
                scoreView.setText(String.valueOf(score));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score =0;
                scoreView.setText(String.valueOf(score));
            }
        });



    }

    public void onSaveInstanceState(@NonNull Bundle savedInstanceState){    // 화면이 회전 등 변경되면 호출
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("score",score);   // 현재 가진 스코어값을 저장
    }


}
