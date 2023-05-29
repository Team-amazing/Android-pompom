package com.example.outopompomme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.outopompomme.home.MypageActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyinfoActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.myinfo_send).setOnClickListener(onClickListener);

        ImageButton myinfo_backkey = findViewById(R.id.myinfo_backkey);


        myinfo_backkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyinfoActivity.this, MypageActivity.class);
                startActivity(intent);
            }
        });
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.myinfo_send:
                    send();
                    break;
            }
        }
    };



    private void send() {
        String email = ((EditText)findViewById(R.id.login_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_password)).getText().toString();

        if(email.length() >0&& password.length() >0){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                strtToast("로그인에 성공했습니다.");
                            } else {
                                if(task.getException() != null){
                                    strtToast(task.getException().toString());
                                }

                            }
                        }
                    });

        }else{
            strtToast("이메일 또는 비밀번호를 입력하세요");
        }
    }

    private void strtToast(String msg) {
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
    }


}