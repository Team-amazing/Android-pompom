package com.example.outopompomme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewWeatherAdapter extends RecyclerView.Adapter<RecyclerViewWeatherAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView weather_itemIv;
        TextView weather_location_itemTv;
        TextView weather_temp_itemTv;
        TextView weather_week_itemTv;
        TextView weather_timeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            weather_itemIv = (ImageView) itemView.findViewById(R.id.weather_itemIv);
            weather_location_itemTv = (TextView) itemView.findViewById(R.id.weather_location_itemTv);
            weather_temp_itemTv = (TextView) itemView.findViewById(R.id.weather_temp_itemTv);
            weather_week_itemTv = (TextView) itemView.findViewById(R.id.weather_week_itemTv);
            weather_timeTv = (TextView) itemView.findViewById(R.id.weather_timeTv);
        }
    }

    private ArrayList<RecyclerViewWeatherItem> mList;

    public RecyclerViewWeatherAdapter(ArrayList<RecyclerViewWeatherItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_wheather_item, parent, false);
        RecyclerViewWeatherAdapter.ViewHolder vh = new RecyclerViewWeatherAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewWeatherAdapter.ViewHolder holder, int position){
        RecyclerViewWeatherItem item = mList.get(position);

        holder.weather_itemIv.setImageResource(R.drawable.partly_cloudy);
        holder.weather_location_itemTv.setText(RecyclerViewWeatherItem.getmLocationText());
        holder.weather_temp_itemTv.setText(RecyclerViewWeatherItem.getmTempText());
        holder.weather_week_itemTv.setText(RecyclerViewWeatherItem.getmWeekText());
        holder.weather_timeTv.setText(RecyclerViewWeatherItem.getmTimeText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}