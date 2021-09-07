package com.cookandroid.finalreport;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDbActivity extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_database);

        getSupportActionBar().setTitle("식단 등록"); //toolbar의 문자를 가슴 운동 루틴으로 띄움

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        myHelper = new myDBHelper(this); //myDBHelper 인스턴스를 생성
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); //쓰기용 데이터베이스로 연다.
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "초기화됨",
                        Toast.LENGTH_SHORT).show(); //토스트 메시지 출력
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // 입력 버튼을 누르면 데이터베이스에 입력된 문자열을 대입
                sqlDB = myHelper.getWritableDatabase(); //쓰기용 데이터베이스로 연다.
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + edtName.getText().toString() + "' , '"
                        + edtNumber.getText().toString() + "');"); //에디트텍스트의 값으로 Insert문을 생성한 다음 실행
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show(); //토스트 메시지 출력
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //조회 버튼을 누르면 데이터베이스에 저장된 문자열을 출력
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                // 커서를 선언하고 모든 테이블을 조회한 후 커서에 대입

                String strNames = "식단" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "시간" + "\r\n" + "--------" + "\r\n";
                // 에디트 텍스의 헤더에 출력될 내용을 미리 변수에 넣어놓는다.

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                // 행 데이터의 개수 만큼 반복

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);
                // 누적한 문자열을 에디트텍스트에 출력

                cursor.close();
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "조회됨",
                        Toast.LENGTH_SHORT).show(); //토스트 메시지 출력
            }
        });
    }
    public void shareBtnClick(View v) { //전송 버튼을 누르면 edtName의 문자열을 어플간에 공유한다.
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, edtName.getText().toString());

        Intent chooser = Intent.createChooser(intent, "공유");
        startActivity(chooser);
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }
        // 생성자 정의, 데이터베이스의 파일명을 지정
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber CHAR(10));");
        } //테이블을 생성, onUpgrade에서 호출되거나, 데이터를 입력할 때 혹은 테이블이 없을 때 1회 호출

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        } // 테이블을 삭제하고 새로 생성, 초기화버튼을 누를때 호출한다.
    }

    public void CloseBtnClick(View v) {
        finish();
    }

}