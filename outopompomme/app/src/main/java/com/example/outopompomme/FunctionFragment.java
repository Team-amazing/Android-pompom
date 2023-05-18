package com.example.outopompomme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class FunctionFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_function, container, false);


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), GivewaterActivity.class);
                startActivity(intent);
            }
        };

        Button button = rootView.findViewById(R.id.give_water_btn);
        button.setOnClickListener(clickListener);

        return rootView;
    }


}