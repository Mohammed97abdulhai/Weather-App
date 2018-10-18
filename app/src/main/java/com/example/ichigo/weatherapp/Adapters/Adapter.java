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

/**
 * Created by ichigo on 10/18/2018.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<String> items;

    public Adapter(Context context,ArrayList<String> items)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.row_layout,parent,false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).day.setText(items.get(position));
        ((Item)holder).max.setText("32"+"\u00B0");
        ((Item)holder).max.setText("21"+"\u00B0");
        ((Item)holder).weather_icon.setImageResource(R.drawable.ic_sun);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class  Item extends RecyclerView.ViewHolder {
        TextView day;
        ImageView weather_icon;
        TextView max,min;
        public Item(View itemView) {
            super(itemView);
            day = (TextView) itemView.findViewById(R.id.day);
            weather_icon = (ImageView) itemView.findViewById(R.id.weather_icon);
            max = (TextView) itemView.findViewById(R.id.max_degree);
            min = (TextView) itemView.findViewById(R.id.min_degree);
        }
    }
}
