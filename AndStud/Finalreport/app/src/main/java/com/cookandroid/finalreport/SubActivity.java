package com.cookandroid.finalreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText name;
    Spinner sex;
    Spinner age;
    EditText weight;
    String sexresult, ageresult;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true); //toolbar에 뒤로가기 버튼 만듬
        getSupportActionBar().setTitle("회원 등록"); //toolbar의 문자를 회원 등록으로 띄움

        name = findViewById(R.id.NameIn);
        sex = findViewById(R.id.SexIn);
        age = findViewById(R.id.AgeIn);
        weight = findViewById(R.id.WeigthIn);

        sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //spinner에서 선택된 문자를 설정한 문자열에 저장
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sexresult = sex.getSelectedItem().toString(); //선택된 문자를 저장
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //spinner에서 선택된 문자를 설정한 문자열에 저장
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ageresult = age.getSelectedItem().toString(); //선택된 문자를 저장
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    public void sendTxt(View v){
        Intent intent = new Intent(this, MainActivity.class);  //MainActivity로 문자열 보낸다
        intent.putExtra("first", name.getText().toString()); //텍스트 정보를 키값과 함께 전달
        intent.putExtra("second", sexresult); //텍스트 정보를 키값과 함께 전달
        intent.putExtra("fourth", ageresult); //텍스트 정보를 키값과 함께 전달
        intent.putExtra("third", weight.getText().toString()); //텍스트 정보를 키값과 함께 전달
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "등록됨",
                Toast.LENGTH_SHORT).show(); //토스트 메시지 출력

    }

    public void CloseBtnClick(View v) {
        finish();
    }




}

