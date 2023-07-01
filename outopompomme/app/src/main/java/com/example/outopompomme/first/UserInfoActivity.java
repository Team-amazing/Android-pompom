package com.example.outopompomme.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.outopompomme.MainActivity;
import com.example.outopompomme.R;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        fragmentContainer = findViewById(R.id.fragment_container);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        showNextFragment(1);
    }

    public void showNextFragment(int currentPage) {
        Log.d("TEST","화면 전환 전");
        switch (currentPage) {
            case 1:
                Log.d("TEST","화면 인");
                fragment = new First1Fragment();
                Log.d("TEST","화면 진짜 인");
                break;
            case 2:
                Log.d("TEST","두번재 화면 인");
                fragment = new First2Fragment();
                break;
            case 3:
                fragment = new First3Fragment();
                break;
            case 4:
                Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
                startActivity(intent);
            default:
                navigateToMainActivity();
                return;
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void navigateToMainActivity() {
        finish();
    }
}