package com.example.cameracapture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView;
    int imagevalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView =  findViewById(R.id.imageView1);

        Intent intent = getIntent();
        String filepath = intent.getStringExtra("filepath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8; // down sizing image as it throws OutOfMemory  Exception for larger images
        filepath = filepath.replace("file://", ""); // remove to avoid  BitmapFactory.decodeFile return null
        File imgFile = new File(filepath);
        if (imgFile.exists()) {
            ImageView imageView = (ImageView) findViewById(R.id.imageView1);
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(),  options);
            imageView.setImageBitmap(bitmap);
        }
    }
    }
