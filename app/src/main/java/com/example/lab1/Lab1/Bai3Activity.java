package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab1.R;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener, Listener {
    Button btnLoadBai3;
    private ImageView img;
    private TextView textView;
    public static final String url = "https://i.pinimg.com/originals/59/c7/a5/59c7a5522ba6d0a37a9b72bb5fbe6c05.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btnLoadBai3 = findViewById(R.id.btnLoadBai3);
        img = findViewById(R.id.imgBai3);
        textView = findViewById(R.id.tvBai3);
        btnLoadBai3.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.btnLoadBai3:
                new LoadImageTask(this,this).execute(url);
                break;
        }
    }

    @Override
    public void onImageLoading(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        textView.setText("Image Download");
    }

    @Override
    public void onError() {
        textView.setText("Error Download");
    }
}