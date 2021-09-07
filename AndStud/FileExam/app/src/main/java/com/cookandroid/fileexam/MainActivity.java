package com.cookandroid.fileexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtEmail;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtemail);
        tvOutput = findViewById(R.id.Text);
    }

    public void onSaveBtnClick(View v) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("data.txt", Context.MODE_PRIVATE)));
            bw.write(txtName.getText() + " , " + txtEmail.getText());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }

    public void onReadBtnClick(View v) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("data.txt")));
            String value = br.readLine();
            tvOutput.setText(value);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Data read error", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }
}