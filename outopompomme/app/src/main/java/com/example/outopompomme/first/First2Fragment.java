package com.example.outopompomme.first;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.outopompomme.R;


public class First2Fragment extends Fragment {

    private Button yesBtn;
    private Button noBtn;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first2, container, false);

        yesBtn = view.findViewById(R.id.fragment2_yes_btn);
        noBtn = view.findViewById(R.id.fragment2_no_btn);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((UserInfoActivity) requireActivity()).showNextFragment(3);
            }
        });
        return view;
    }
}