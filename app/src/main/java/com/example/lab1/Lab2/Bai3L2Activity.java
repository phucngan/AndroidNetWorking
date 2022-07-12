package com.example.lab1.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai3L2Activity extends AppCompatActivity {
    public static final String SERVER_BAI3 = "http://192.168.1.6:1900/bai3";
    TextView tvB3L2;
    EditText edB3L2;
    Button btnB3L2;
    String canh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_l2);
        tvB3L2 = findViewById(R.id.tvB3L2);
        edB3L2 = findViewById(R.id.edB3L2);
        btnB3L2 = findViewById(R.id.btnB3L2);
        btnB3L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canh = edB3L2.getText().toString();
                BackgroundTask_Bai3 backgroundTask_bai3 = new BackgroundTask_Bai3(tvB3L2,canh,getApplicationContext());
                backgroundTask_bai3.execute();
            }
        });
    }
}