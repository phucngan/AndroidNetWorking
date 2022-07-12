package com.example.lab1.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai4L2Activity extends AppCompatActivity {
    public static final String SERVER_Bai4 = "http://192.168.1.6:1900/bai4";
    TextView tvB4L2;
    EditText edA,edB,edC;
    Button btnB4L2;
    String a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_l2);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);
        tvB4L2 = findViewById(R.id.tvB4L2);
        btnB4L2 = findViewById(R.id.btnB4L2);
        btnB4L2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edA.getText().toString();
                b = edB.getText().toString();
                c = edC.getText().toString();
                BackgroundTask_Bai4 backgroundTask_bai4 = new BackgroundTask_Bai4(tvB4L2,a,b,c,getApplicationContext());
                backgroundTask_bai4.execute();
            }
        });
    }
}