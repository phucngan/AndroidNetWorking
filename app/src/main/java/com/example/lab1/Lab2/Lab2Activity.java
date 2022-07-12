package com.example.lab1.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab1.Lab1.Lab1Activity;
import com.example.lab1.MainActivity;
import com.example.lab1.R;

public class Lab2Activity extends AppCompatActivity {
    Button bai1,bai2,bai3,bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        bai1 = findViewById(R.id.btnL2b1);
        bai2 = findViewById(R.id.btnL2b2);
        bai3 = findViewById(R.id.btnL2b3);
        bai4 = findViewById(R.id.btnL2b4);

        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Bai1L2Activity.class);
                startActivity(intent);
            }
        });
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Bai2L2Activity.class);
                startActivity(intent);
            }
        });
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Bai3L2Activity.class);
                startActivity(intent);
            }
        });
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab2Activity.this, Bai4L2Activity.class);
                startActivity(intent);
            }
        });
    }
}