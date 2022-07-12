package com.example.lab1.Lab1;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoading(Bitmap bitmap);
    void onError();
}
