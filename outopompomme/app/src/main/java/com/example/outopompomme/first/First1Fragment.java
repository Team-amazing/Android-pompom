package com.example.outopompomme.first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.outopompomme.R;


public class First1Fragment extends Fragment {
    private EditText usernikname;
    private ImageButton nextBtn;



    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first1, container, false);

        Log.d("TEST","프래그먼트 인");

        usernikname = view.findViewById(R.id.fragment1_nikname_et);
        nextBtn = view.findViewById(R.id.frament1_next_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((UserInfoActivity) requireActivity()).showNextFragment(2);
            }
        });
        Log.d("TEST","프래그먼트 끝");
        return view;
    }
}