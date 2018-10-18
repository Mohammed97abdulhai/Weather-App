package com.example.ichigo.weatherapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.ichigo.weatherapp.Adapters.Adapter;
import com.example.ichigo.weatherapp.Adapters.Horizontal_Adapter;
import com.example.ichigo.weatherapp.Mc2Service;
import com.example.ichigo.weatherapp.R;
import com.example.ichigo.weatherapp.models.WeatherData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Weather extends AppCompatActivity {

    RecyclerView recyclerView,horizontal_recyclerview;
    Adapter adapter;
    Horizontal_Adapter horizontal_adapter;
    ArrayList<String> items , horizontal_items;
    List<String> items1 = Arrays.asList("Tomorrow","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday");

    final static String BaseUrl = "http://api.openweathermap.org/data/2.5/";
    final static String apikey = "f0ca18a0a7c414bde9cd9d37a59890cd";
    final static String lat = "55.5";
    final static String lon = "37.5";
    final static String cnt ="10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("New Delhi, India");

        horizontal_items = new ArrayList<>();
        horizontal_items.add("nothing");
        horizontal_items.add("nothing1");
        horizontal_recyclerview = (RecyclerView) findViewById(R.id.sliding_list);
        horizontal_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        horizontal_adapter = new Horizontal_Adapter(this,horizontal_items);
        horizontal_recyclerview.setAdapter(horizontal_adapter);

        items = new ArrayList<>();
        items.addAll(items1);
        recyclerView = (RecyclerView) findViewById(R.id.main_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,items);
        recyclerView.setAdapter(adapter);
        getdata();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    void getdata()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory
                (GsonConverterFactory.create()).build();
        Mc2Service mc2Service = retrofit.create(Mc2Service.class);

        Call<WeatherData> call = mc2Service.getWeatherInfo(lat,lon,cnt,apikey);


        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }
}
