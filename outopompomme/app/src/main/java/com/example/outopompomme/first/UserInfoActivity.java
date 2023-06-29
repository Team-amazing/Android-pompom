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

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.outopompomme.LoginActivity;
import com.example.outopompomme.R;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private FrameLayout fragmentContainer;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        fragmentContainer = findViewById(R.id.fragment_container);

        showNextFragment();
    }

    public void showNextFragment() {
        Log.d("TEST","화면 전환 전");
        Fragment fragment;
        switch (currentPage) {
            case 1:
                Log.d("TEST","화면 인");
                fragment = new First1Fragment();
                Log.d("TEST","화면 진짜 인");
                break;
            case 2:
                fragment = new First2Fragment();
                break;
            default:
                navigateToMainActivity();
                return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void navigateToMainActivity() {
        finish();
    }
}