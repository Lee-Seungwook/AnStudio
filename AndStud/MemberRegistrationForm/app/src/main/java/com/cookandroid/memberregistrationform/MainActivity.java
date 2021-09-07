package com.cookandroid.memberregistrationform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton photo;
    SeekBar age;
    TextView ageTxt;
    Spinner spinner;
    TextView birthDay;

    private ActionMode mActionMode;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = findViewById(R.id.photoBtn);
        age = findViewById(R.id.ageSeekBar);
        ageTxt = findViewById(R.id.age);
        spinner = findViewById(R.id.jobList);
        birthDay = findViewById(R.id.birthdayInput);

        photo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode != null) return false;
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;
            }
        });

        /*age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageTxt.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/
        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageTxt.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //1. 플로팅 컨텍스트 메뉴로 등록
        //registerForContextMenu(photo);

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

public void onSaveBtnClicked (View v) {
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setTitle("Save Member Information");
    builder.setMessage("clickclcik not click is the first thing that human made");

    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            toastMsg("OK pressed!!");
        }
    });

    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            toastMsg("Cancel pressed !!");
        }
    });
    builder.show();
}

public void onBirthdayBtnClicked(View v) {
    DatePickerDialog dialog = new DatePickerDialog(this);
    //기본 선택 날짜 지정 dialog.getDatePicker().updateDate(2000,10,10)
    dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            birthDay.setText(year + ". " +month + ". " + dayOfMonth);
        }
    });
    dialog.show();
}

public ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_cab, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cab_photo: toastMsg("Add photo"); break;
            case R.id.cab_avatar: toastMsg("Add avatar"); break;
            case R.id.cab_reset: toastMsg("Reset to default"); break;
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
};

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Action Bar 메뉴 아이템 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new:
                toastMsg("New Member");
                break;
            case R.id.action_del:
                toastMsg("Delete member");
                break;
            case R.id.action_search:
                toastMsg("Search member");
                break;
            case R.id.action_list:
                toastMsg("List member");
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    // 이벤트 확인용 토스트 메시지 출력 메서드
    void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //  컨텍스트 메뉴 생성시 메뉴 등록
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_fcm, menu);
    }

    //컨텍스트 메뉴 아이템 선택시 이벤트 처리

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ctx_photo: toastMsg("Add photo"); break;
            case R.id.ctx_avatar: toastMsg("Add Avatar"); break;
            case R.id.ctx_reset: toastMsg("Reset to default"); break;
        }
        return super.onContextItemSelected(item);
    }









}
