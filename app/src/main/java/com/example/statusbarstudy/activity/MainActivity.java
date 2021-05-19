package com.example.statusbarstudy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.statusbarstudy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void test1(View view) {
        Intent intent = new Intent(MainActivity.this,TranslucentActivity.class);
        startActivity(intent);
    }

    public void test2(View view) {
        Intent intent = new Intent(MainActivity.this, Test2Activity.class);
        startActivity(intent);
    }

    public void test3(View view) {

    }

    public void test4(View view) {

    }
}