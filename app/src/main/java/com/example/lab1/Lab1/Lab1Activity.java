package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab1.R;

public class Lab1Activity extends AppCompatActivity {
    Button bai1, bai2 ,bai3,bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        bai1 = findViewById(R.id.btnBai1);
        bai2 = findViewById(R.id.btnBai2);
        bai3 = findViewById(R.id.btnBai3);
        bai4 = findViewById(R.id.btnbai4);

        bai1.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this,Bai1Activity.class);
            startActivity(intent);
        });
        bai2.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this,SplashActivity.class);
            startActivity(intent);
        });
        bai3.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this,Bai3Activity.class);
            startActivity(intent);
        });
        bai4.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this,Bai4Activity.class);
            startActivity(intent);
        });
    }
}