package com.suhun.sensorcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView v1, v2, v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        v1 = findViewById(R.id.lid_v1);
        v2 = findViewById(R.id.lid_v2);
        v3 = findViewById(R.id.lid_v3);
    }
}