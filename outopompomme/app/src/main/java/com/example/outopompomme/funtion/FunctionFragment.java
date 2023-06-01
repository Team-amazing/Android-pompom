package com.example.outopompomme.funtion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.outopompomme.ApiTest;
import com.example.outopompomme.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.Executors;


public class FunctionFragment extends Fragment {

    private ApiTest at;



    public FunctionFragment(){

    }

    //api연동
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        at = new ApiTest();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    at.func();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }


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