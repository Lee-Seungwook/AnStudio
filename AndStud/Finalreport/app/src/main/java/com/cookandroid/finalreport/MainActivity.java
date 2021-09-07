package com.cookandroid.finalreport;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    Button save;
    Button chest;
    Button back;
    Button leg;
    TextView name;
    TextView sex;
    TextView age;
    TextView weight;
    TextView food;
    String nametxt, sextxt, agetxt, weighttxt;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        save = findViewById(R.id.Save);
        food = findViewById(R.id.Food);
        chest = findViewById(R.id.Up);
        back = findViewById(R.id.Down);
        leg = findViewById(R.id.Exercise);
        name = findViewById(R.id.Nameout);
        sex = findViewById(R.id.SexOut);
        age = findViewById(R.id.AgeOut);
        weight = findViewById(R.id.Weightout);

        Intent intent = getIntent();
        nametxt = intent.getStringExtra("first");
        if (nametxt != null){
            name.setText(nametxt);
            food.setText(nametxt + "님의 식단을 작성해주세요!"); //nametxt에 저장된 문자열과 입력한 문자열로 food문자열 설정
        }

        sextxt = intent.getStringExtra("second"); //SubActivity에서 작성된 키 값을 받아 문자열을 저장
        if (sextxt != null) //null값이 아닌경우
            sex.setText(sextxt);

        agetxt = intent.getStringExtra("fourth"); //SubActivity에서 작성된 키 값을 받아 문자열을 저장
        if(agetxt != null) //null값이 아닌경우
            age.setText(agetxt);

        weighttxt = intent.getStringExtra("third"); //SubActivity에서 작성된 키 값을 받아 문자열을 저장
        if (weighttxt != null) //null값이 아닌경우
            weight.setText(weighttxt);







    }


    public void openSubActivity(View v) { //onclik메서드를 활용한 SubAcitivity 호출
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }

    public void openFoodDbActivity(View v) { //onclik메서드를 활용한 FoodDbActivity 호출
        Intent intent = new Intent(this, FoodDbActivity.class);
        startActivity(intent);
    }
    public void openChestActivity(View v) { //onclik메서드를 활용한 ChestActivity 호출
        Intent intent = new Intent(this, ChestActivity.class);
        startActivity(intent);
    }

    public void openBackActivity(View v) { //onclik메서드를 활용한 BackAcitivity 호출
        Intent intent = new Intent(this, BackActivity.class);
        startActivity(intent);
    }

    public void openLegActivity(View v) { //onclik메서드를 활용한 LegAcitivity 호출
        Intent intent = new Intent(this, LegActivity.class);
        startActivity(intent);
    }








}