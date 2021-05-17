package com.example.statusbarstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View yourView = findViewById(R.id.cl);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (yourView != null) {
//                yourView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            }
//        }
    }
}