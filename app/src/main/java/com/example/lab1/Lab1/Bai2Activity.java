package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.MainActivity;
import com.example.lab1.R;

import java.io.Console;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {
    private String url = "https://anhdep123.com/wp-content/uploads/2020/11/anh-hoat-hinh-anime-dep-kute.jpg";
    private Button loadimg;
    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    private ImageView img;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        loadimg = findViewById(R.id.btnLoadImg);
        img = findViewById(R.id.imgBai2);
        textView = findViewById(R.id.tvBai2);
        loadimg.setOnClickListener(this);
    }

    public Handler messagehandler = new Handler(){
        public void handleMessage(Message message){
            super.handleMessage(message);
            Bundle bundle = message.getData();
            String msg = bundle.getString("message","Load Image Successful!");
            textView.setText(msg);
            img.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };



    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(Bai2Activity.this,"","Downloading...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message message = messagehandler.obtainMessage();
                Bundle bundle = new Bundle();

                bundle.putString("Message","Image Download");
                message.setData(bundle);
                messagehandler.sendMessage(message);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private Bitmap downloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}