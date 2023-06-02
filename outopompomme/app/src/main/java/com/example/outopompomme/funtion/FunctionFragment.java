package com.example.outopompomme.funtion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.outopompomme.ApiTest;
import com.example.outopompomme.R;
import com.example.outopompomme.RecyclerViewWeatherItem;
import com.example.outopompomme.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class FunctionFragment extends Fragment {

    private ApiTest at;
    private Button give_water_btn;
    private Button light_btn;
    private Button open_door_btn;
    private Button water_box_btn;

    private ViewPager2 mViewPager;
    private ArrayList<RecyclerViewWeatherItem> mList;
    private WeatherAdapter weatherAdapter;



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
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_function, container, false);

        give_water_btn = rootView.findViewById(R.id.give_water_btn);
        light_btn = rootView.findViewById(R.id.light_btn);
        open_door_btn = rootView.findViewById(R.id.open_door_btn);
        water_box_btn = rootView.findViewById(R.id.watter_box_btn);


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

        water_box_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WatertanckActivity.class);
                startActivity(intent);
            }
        });
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstance){
        super.onViewCreated(view, savedInstance);

        firstTint();

        for(int i=0;i<7;i++){
            addItem("DAEJEON", "iconName", "16°C", "WEDNESDAY", "15:37 PM");
        }

        mViewPager = view.findViewById(R.id.viewpager);
        weatherAdapter = new WeatherAdapter(mList);
        mViewPager.setAdapter(weatherAdapter);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        //layoutManager.setOrientation(ViewPager2.HORIZONTAL);
        ViewPager2 mviewPager = view.findViewById(R.id.viewpager);
        mviewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mviewPager.setAdapter(weatherAdapter);
    }

    public void firstTint() {
        mList = new ArrayList<>();
    }

    public void addItem(String locationText, String imgName, String tempText, String weekText, String timeText) {
        RecyclerViewWeatherItem item = new RecyclerViewWeatherItem();

        item.setmLocationText(locationText);
        item.setmImgName(imgName);
        item.setmTempText(tempText);
        item.setmWeekText(weekText);
        item.setmTimeText(timeText);

        mList.add(item);
    }



}