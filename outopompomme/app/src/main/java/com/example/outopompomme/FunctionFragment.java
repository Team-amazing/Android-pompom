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

        Button give_water_btn = rootView.findViewById(R.id.give_water_btn);
        Button light_btn = rootView.findViewById(R.id.light_btn);
        Button open_door_btn = rootView.findViewById(R.id.open_door_btn);
        Button watter_box_btn = rootView.findViewById(R.id.watter_box_btn);

        give_water_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GivewaterActivity.class);
                startActivity(intent);
            }
        });

        light_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LightActivity.class);
                startActivity(intent);
            }
        });

        open_door_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OpendoorActivity.class);
                startActivity(intent);
            }
        });

        watter_box_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WatertanckActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


}