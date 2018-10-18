package com.example.ichigo.weatherapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ichigo.weatherapp.R;

import java.util.ArrayList;

public class Horizontal_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<String> items;

    public Horizontal_Adapter(Context context, ArrayList<String> items)
    {
        this.context = context;
        this.items = items;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.row_layout_horizontal, parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).dayandhour.setText("Today, 12:00PM");
        ((Item)holder).degree.setText("28"+"\u00B0"+"C");
    }

    @Override
    public int getItemCount() {
        return items.size();}

    class Item extends RecyclerView.ViewHolder {
        TextView dayandhour;
        ImageView icon;
        TextView degree,status;

        public Item(View itemView) {
            super(itemView);
            dayandhour = (TextView) itemView.findViewById(R.id.dayandhour);
            icon = (ImageView) itemView.findViewById(R.id.weather_bigicon);
            degree  = (TextView) itemView.findViewById(R.id.degree);
            status = (TextView) itemView.findViewById(R.id.weather_status);
        }
    }
}
