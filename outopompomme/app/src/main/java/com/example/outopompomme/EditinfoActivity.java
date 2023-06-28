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
import com.google.firebase.auth.FirebaseAuth;

public class EditinfoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.editinfo_send).setOnClickListener(onClickListener);

        ImageButton editinfo_backkey = findViewById(R.id.editinfo_backkey);


        editinfo_backkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditinfoActivity.this, MypageActivity.class);
                startActivity(intent);
            }
        });
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.editinfo_send:
                    send();
                    break;
            }
        }
    };



    private void send() {
        String email = ((EditText)findViewById(R.id.login_email)).getText().toString();

        if(email.length() >0){
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                strtToast("이메일을 보냈습니다.");
                            }
                        }
                    });

        }else{
            strtToast("이메일을 입력하세요");
        }
    }

    private void strtToast(String msg) {
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
    }
}