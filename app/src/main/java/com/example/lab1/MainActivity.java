package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab1.Lab1.Lab1Activity;
import com.example.lab1.Lab2.Lab2Activity;

public class MainActivity extends AppCompatActivity {
    private Button Lab1,Lab2,Lab3,Lab4,Lab5,Lab6,Lab7,Lab8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lab1 = findViewById(R.id.btnLab1);
        Lab2 = findViewById(R.id.btnLab2);
        Lab3 = findViewById(R.id.btnLab3);
        Lab4 = findViewById(R.id.btnLab4);
        Lab5 = findViewById(R.id.btnLab5);
        Lab6 = findViewById(R.id.btnLab6);
        Lab7 = findViewById(R.id.btnLab7);
        Lab8 = findViewById(R.id.btnLab8);

        Lab1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Lab1Activity.class);
            startActivity(intent);
        });
        Lab2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Lab2Activity.class);
            startActivity(intent);
        });
    }


}