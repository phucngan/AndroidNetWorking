package com.example.lab1.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai2L2Activity extends AppCompatActivity {
    public static final String SERVER_BAI2 = "http://192.168.1.6:1900/bai2";
    EditText edCR,edCD;
    Button btnL2B2;
    TextView tvL2B2;
    String rong,dai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_b2);
        edCR = findViewById(R.id.edCR);
        edCD = findViewById(R.id.edCD);
        btnL2B2 = findViewById(R.id.btnL2B2);
        tvL2B2 = findViewById(R.id.tvL2B2);
        btnL2B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rong = edCR.getText().toString();
                dai = edCD.getText().toString();
                BackgroundTask_Post backgroundTask_post = new BackgroundTask_Post(tvL2B2,rong,dai,getApplicationContext());
                backgroundTask_post.execute();

            }
        });
    }
}