package com.example.outopompomme.home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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


public class MyinfoActivity extends AppCompatActivity {

    Uri uri;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        Button selectBtn = findViewById(R.id.myinfo_image_select_btn);
        imageView = findViewById(R.id.myinfo_iv);

        //boolean hasWritePerm = checkSelfPermission(Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION) == PackageManager.PERMISSION_GRANTED;
        //if (!hasWritePerm)  // 권한 없을 시  권한설정 요청
        //    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION}, 1);



        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                //registerForActivityResult(intent, 101);
                startActivityForResult(intent, 101);
                Log.d("TEST","버튼 클릭");
            }
        });

        Log.d("TEST","sdsdfs");

    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d("TEST","갤러리 결과"+result);
                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        //Intent intent = result.getData();
                        //uri = intent.getData();
                        uri = result.getData().getData();

                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                            imageView.setImageBitmap(bitmap);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        Log.d("TEST","갤럴;"+uri);
                    }
                }
            });
}



