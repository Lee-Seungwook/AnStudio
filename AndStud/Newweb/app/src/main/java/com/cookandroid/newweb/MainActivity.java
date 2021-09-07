package com.cookandroid.newweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl=findViewById(R.id.edtUrl);
        btnGo=findViewById(R.id.btnGo);
        btnBack=findViewById(R.id.btnBack);
        web=findViewById(R.id.webView1);

        web.setWebViewClient(new WebViewClient()); //클래스를 생성하여 웹뷰에 대입

        WebSettings webSet=web.getSettings();
        webSet.setBuiltInZoomControls(true); // 줌 버튼 컨트롤이 화면에 보이게 한다.

        btnGo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                web.loadUrl(edtUrl.getText().toString()); //입력한 url 웹페이지가 웹뷰에 나오가 한다.
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                web.goBack();
            }
        });

        web.getSettings().setDomStorageEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);
    }
}
