package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab1.R;

import java.net.URL;

public class Bai1Activity extends AppCompatActivity implements View.OnClickListener  {
    private Button button;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.img);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(this);
    }
    private Bitmap LoadImagefromServer (String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public void onClick(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bm = LoadImagefromServer("https://giadinh360.vn/wp-content/uploads/2020/09/hinh-anh-hoat-hinh-de-thuong-30.png");
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Image Download");
                        imageView.setImageBitmap(bm);
                        Toast.makeText(getApplicationContext(),"LoadImage Successtful",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        thread.start();
    }
}