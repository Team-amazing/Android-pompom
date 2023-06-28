package com.example.outopompomme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class ChangePwActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.myinfo_checkBtn:
                        profileUpdate();
                        break;

                }
            }
        };

        findViewById(R.id.myinfo_checkBtn).setOnClickListener(onClickListener);



    }

    private void profileUpdate() {
        //String id = ((EditText) findViewById(R.id.myinfo_idEt)).getText().toString();
        String email = ((EditText) findViewById(R.id.myinfo_emailEt)).getText().toString();

        if (email.length() > 0 ) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(email)
                    .build();
            if(user != null){
                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    startToast("회원 정보 등록에 성공하셨습니다.");

                                }
                            }
                        });
            }
            startToast("이메일이 일치하지 않습니다.");

        } else {
            startToast("회원 정보를 입력해주세요");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}