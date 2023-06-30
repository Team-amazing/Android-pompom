package com.example.outopompomme.first;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.outopompomme.MainActivity;
import com.example.outopompomme.R;


public class First3Fragment extends Fragment {

    private Button registrationBtn;
    private Button afterBtn;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first3, container, false);

        registrationBtn = view.findViewById(R.id.fragment3_registration_btn);
        afterBtn = view.findViewById(R.id.fragment3_after_btn);

        afterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((UserInfoActivity) requireActivity()).showNextFragment(4);
                //Intent intent = new Intent(First3Fragment.this, MainActivity.class);
                //startActivity(intent);
            }
        });
        return view;

    }
}