package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBai4;
    private TextView tvResult;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        btnBai4 = findViewById(R.id.btnLoadBai4);
        tvResult = findViewById(R.id.tvResultl2);
        editText = findViewById(R.id.edBai4);
        btnBai4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoadBai4:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this,tvResult,editText);
                String sleepTime = editText.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;
        }
    }
}