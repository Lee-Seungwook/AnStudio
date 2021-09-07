package com.example.basicexam2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Context CONTEXT;
    List<Product> products;
    ListView plistview;
    ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CONTEXT = this;

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductAddActivity.class);
                startActivity(intent);
            }
        });

        // genSampleData();

        dao = ProductDAO.open(this);
        products = dao.getAll();

        plistview = findViewById(R.id.item_view);
        ProductAdapter adapter = new ProductAdapter(this,R.layout.list_item, products);
        plistview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ProductAdapter adapter = (ProductAdapter) plistview.getAdapter();
        adapter.products = dao.getAll();
        adapter.notifyDataSetChanged();
    }

    // DB 없이 초기 UI 테스트용 샘플 데이터 생성
    void genSampleData() {
        products = new ArrayList<>();

        Product p = new Product("Galaxy Note 10", "Samsung",1500000);
        products.add(p);
        p = new Product("Galaxy S 11", "Samsung",1300000);
        products.add(p);
        p = new Product("iPhone 11", "Apple",1300000);
        products.add(p);
        p = new Product("iPhone 11R", "Apple",1100000);
        products.add(p);
        p = new Product("iPhone 11 Max", "Apple",1600000);
        products.add(p);
    }
}
