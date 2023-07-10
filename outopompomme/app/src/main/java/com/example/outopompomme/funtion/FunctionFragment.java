package com.example.outopompomme.funtion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.outopompomme.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FunctionFragment extends Fragment {

    //private ApiTest at;
    private Button give_water_btn;
    private Button light_btn;
    private Button open_door_btn;
    private Button water_box_btn;

    private ViewPager2 mViewPager;
    //private ArrayList<RecyclerViewWeatherItem> mList;
    //private WeatherAdapter weatherAdapter;

    private TextView temperatureTv;
    private TextView humidityTv;

    private FirebaseDatabase mDatabase;



    public FunctionFragment() {
        // Required empty public constructor
    }



    //api연동
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //at = new ApiTest();
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    at.func();
//                } catch (Throwable e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_function, container, false);

        give_water_btn = rootView.findViewById(R.id.give_water_btn);
        light_btn = rootView.findViewById(R.id.light_btn);
        open_door_btn = rootView.findViewById(R.id.open_door_btn);
        water_box_btn = rootView.findViewById(R.id.watter_box_btn);

        temperatureTv = rootView.findViewById(R.id.funtion_RealtempTv);
        humidityTv = rootView.findViewById(R.id.funtion_real_humTv);


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



        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myTem = mDatabase.getReference("tem");

        myTem.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String temp = snapshot.getValue(String.class);
                String hum = snapshot.getValue(String.class);
                Log.d("TEST","온도"+temp);
                Log.d("TEST","습도"+hum);
                temperatureTv.setText(temp);


                for(DataSnapshot ds : snapshot.getChildren()) {
                    String key = ds.getKey();

                    //String temp = ds.child("tem").getValue(String.class);

                    //temperatureTv.setText(temp);
                    //Log.d("TEST","온도"+temp);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
        //weatherAdapter = new WeatherAdapter(mList);
        //mViewPager.setAdapter(weatherAdapter);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        //layoutManager.setOrientation(ViewPager2.HORIZONTAL);
        ViewPager2 mviewPager = view.findViewById(R.id.viewpager);
        mviewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //mviewPager.setAdapter(weatherAdapter);
    }

    public void firstTint() {
        //mList = new ArrayList<>();
    }

    public void addItem(String locationText, String imgName, String tempText, String weekText, String timeText) {
        //RecyclerViewWeatherItem item = new RecyclerViewWeatherItem();

//        item.setmLocationText(locationText);
//        item.setmImgName(imgName);
//        item.setmTempText(tempText);
//        item.setmWeekText(weekText);
//        item.setmTimeText(timeText);
//
//        mList.add(item);
    }

//    public void updateSensorData(String data) {
//        String[] values = data.split(",");
//        if(values.length == 2) {
//            String temperatureValue = values[0].split(":")[1];
//            String humidityValue = values[1].split(":")[1];
//            temperatureTextView.setText(temperatureValue);
//            humidityTextView.setText(humidityValue);
//        }
//    }



}