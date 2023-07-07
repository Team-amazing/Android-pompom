package com.example.outopompomme.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.outopompomme.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import kotlin.Suppress;
import retrofit2.http.GET;


public class MyinfoActivity extends AppCompatActivity {

    //Uri uri;
    //ImageView imageView;
    private static final int GALLERY_REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        Button selectBtn = findViewById(R.id.myinfo_image_select_btn);





    }


    public void openGallery(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(resultCode, resultCode, data);
        Log.d("TEST","이미지 전");
        Log.d("TEST","resultcide"+resultCode+","+GALLERY_REQUEST_CODE);

        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            String[] filePathColum = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(uri,filePathColum,null,null,null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColum[0]);
            String imagePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = findViewById(R.id.myinfo_iv);
            imageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            Log.d("TEST","이미지");

        }
    }

}



