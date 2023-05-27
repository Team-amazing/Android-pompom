package com.example.outopompomme.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.outopompomme.DiaryActivity;
import com.example.outopompomme.R;

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Button mypage_daiary_btn = findViewById(R.id.mypage_daiary_btn);

        mypage_daiary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this , DiaryActivity.class);
                startActivity(intent);

            }
        });
    }
}