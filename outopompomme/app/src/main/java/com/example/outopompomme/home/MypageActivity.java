package com.example.outopompomme.home;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.outopompomme.DiaryActivity;
import com.example.outopompomme.LinkarduinoActivity;
import com.example.outopompomme.PlantTypesActivity;
import com.example.outopompomme.R;
import com.example.outopompomme.first.StartActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Button mypage_daiary_btn = findViewById(R.id.mypage_daiary_btn);

        Button mypage_plantBtn = findViewById(R.id.mypage_plantBtn);

        Button mypage_link_arduino = findViewById(R.id.mypage_link_arduino);

        findViewById(R.id.mypage_logoutBtn).setOnClickListener(onClickListener);

        Button mypage_myinfoBtn = findViewById(R.id.mypage_myinfoBtn);

        ImageButton mypage_backkey = findViewById(R.id.mypage_backkey);



        mypage_daiary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this , DiaryActivity.class);
                startActivity(intent);

            }
        });

        mypage_plantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this, PlantTypesActivity.class);
                startActivity(intent);
            }
        });

        mypage_link_arduino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this, LinkarduinoActivity.class);
                startActivity(intent);
            }
        });

        mypage_myinfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MypageActivity.this, MyinfoActivity.class);
                startActivity(intent);
            }
        });

        mypage_backkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mypage_logoutBtn:
                    FirebaseAuth.getInstance().signOut();
                    startActivity();
                    break;
            }
        }
    };



    private void startActivity() {
        Intent intent = new Intent(MypageActivity.this, StartActivity.class);
        startActivity(intent);
    }
}