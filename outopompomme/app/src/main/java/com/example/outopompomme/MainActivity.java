package com.example.outopompomme;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.outopompomme.funtion.FunctionFragment;
import com.example.outopompomme.home.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    FunctionFragment functionFragment;
    MusicFragment musicFragment;
    InfoFragment infoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity();
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



    private void startActivity() {
        Intent intent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(intent);
    }
}