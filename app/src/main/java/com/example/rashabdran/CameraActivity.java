package com.example.rashabdran;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CAMERA_REQUEST = 0 ;// the code for the request from the camera
    private ImageView imageView;
    private Button takePhotoButton, galleryButton;
    private Bitmap bitmap;// this var will hold the photo of the camera


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    //create the display objects so they can be programmed
        imageView = findViewById(R.id.imageView);
        takePhotoButton= findViewById(R.id.TakePhotoButton);
        takePhotoButton.setOnClickListener(this);
        galleryButton = findViewById(R.id.GalleryButton);
        galleryButton.setOnClickListener(this);
    }

    @Override
    @RequiresApi (api = Build.VERSION_CODES.M)
    public void onClick(View view) {
        if (view== takePhotoButton){
            //check if the permission for camera ws not granted
            if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
            }
            // camera
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // i use the intent 3shan ash4l alcamera
            startActivityForResult(i, CAMERA_REQUEST);
        }else  if (view == galleryButton){
            //gallery
        }
    }
    // this method grants the permission according to the request code
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_REQUEST){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No Permission Was Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST &&requestCode == RESULT_OK){ // hl ana nj7t aswr aza aa 5od alsora b data w23rd alsora 3n trek al bitmap .
            bitmap = ( Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}