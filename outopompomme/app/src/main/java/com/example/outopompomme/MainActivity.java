package com.example.outopompomme;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.outopompomme.funtion.FunctionFragment;
import com.example.outopompomme.home.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

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
            startActivity(MyinfoActivity .class);
        }else{
            for (UserInfo profile : user.getProviderData()) {
                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();
            }

        }


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


}