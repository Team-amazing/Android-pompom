package com.example.outopompomme.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.outopompomme.R;
import com.example.outopompomme.first.LoginActivity;
import com.example.outopompomme.first.UserInfoActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signupBtn).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.signupBtn:
                    signUp();
                    break;
            }
        }
    };


    private void signUp() {
        String email = ((EditText)findViewById(R.id.signup_EmailAddress)).getText().toString();
        String password = ((EditText)findViewById(R.id.signup_password)).getText().toString();
        String signup_check_password = ((EditText)findViewById(R.id.signup_check_password)).getText().toString();

        if(email.length() >0&& password.length() >0 && signup_check_password.length() >0){
            if(password.equals(signup_check_password)) {

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    strtToast("회원가입이 성공적으로 되었습니다.");
                                    myStartActivity(UserInfoActivity.class);


                                } else {
                                    if(task.getException() != null){
                                        strtToast(task.getException().toString());

                                    }
                                }
                            }
                        });
            }else{
                strtToast("비밀번호가 일치하지 않습니다.");
            }
        }else{
            strtToast("이메일 또는 비밀번호를 입력하세요");
        }


    }

    private void strtToast(String msg) {
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();

    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }




}