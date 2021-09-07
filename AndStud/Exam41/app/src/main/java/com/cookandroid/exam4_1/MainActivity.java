package com.cookandroid.exam4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    int num1;
    int num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1=findViewById(R.id.Edit1);
        edit2=findViewById(R.id.Edit2);

        btnAdd=findViewById(R.id.BtnAdd);
        btnSub=findViewById(R.id.BtnSub);
        btnMul=findViewById(R.id.BtnMul);
        btnDiv=findViewById(R.id.BtnDiv);

        textResult=findViewById(R.id.TextResult);



    /*
        btnAdd.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)+Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)-Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)*Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1=edit1.getText().toString();
                num2=edit2.getText().toString();
                result=Integer.parseInt(num1)/Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });*/
    }
    //더하기 이벤트 처리
    /*public void addBtnClick(View view) {
        num1=edit1.getText().toString();
        num2=edit2.getText().toString();
        result=Integer.parseInt(num1) + Integer.parseInt(num2);
        textResult.setText("계산 결과 : " + result.toString());
    }*/

    public void calc(View view) {
        num1=Integer.parseInt(edit1.getText().toString());
        num2=Integer.parseInt(edit2.getText().toString());

        int id=view.getId();
        switch (id){
            case R.id.BtnAdd: result=num1+num2; textResult.setText("계산 결과: " + result.toString()); break;
            case R.id.BtnSub: result=num1-num2; textResult.setText(result.toString());break;
            case R.id.BtnDiv: result=num1/num2; textResult.setText(result.toString());break;
            case R.id.BtnMul: result=num1*num2; textResult.setText(result.toString());break;
        }
    }
}
