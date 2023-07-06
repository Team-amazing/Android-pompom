package com.example.outopompomme;


import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;

import com.example.outopompomme.first.StartActivity;
import com.example.outopompomme.first.UserInfoActivity;
import com.example.outopompomme.funtion.FunctionFragment;
import com.example.outopompomme.home.HomeFragment;
import com.example.outopompomme.home.MyinfoActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    FunctionFragment functionFragment;
    MusicFragment musicFragment;
    InfoFragment infoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null) {
            startActivity(MyinfoActivity.class);
        }else{
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef = db.collection("users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        DocumentSnapshot document = task.getResult();
                        if(document != null){
                            if(document.exists()){
                                if(document.getData() == null){
                                    myStartActivity(UserInfoActivity.class);
                                }else {
                                    Log.d(TAG,"검색 안됨");
                                }
                            }
                        }
                    }
                }
            });
        }
//            for (UserInfo profile : user.getProviderData()) {
//                // Name, email address, and profile photo Url
//                //String name = profile.getDisplayName();
//                String email = profile.getEmail();
//                Uri photoUrl = profile.getPhotoUrl();
//
//
//                String nickname = profile.getDisplayName();
//                Log.d("TEST","닉네임 전"+ nickname);
//                //Log.d("TEST","닉네임"+nickname.length());
//                if(nickname == null){
//                    Log.d("TEST","닉네임"+nickname);
//                    myStartActivity(UserInfoActivity.class);
//                }
//            }
//        }

        homeFragment = new HomeFragment();
        functionFragment = new FunctionFragment();
        musicFragment = new MusicFragment();
        infoFragment = new InfoFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottomNav);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                        return true;
                    case R.id.function:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, functionFragment).commit();
                        return true;
                    case R.id.music:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, musicFragment).commit();
                        return true;
                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers, infoFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }



    private void startActivity(Class<MyinfoActivity> myinfoActivityClass) {
        Intent intent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(intent);
    }

    private void myStartActivity(Class c){
        Intent intent = new Intent(this,c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}