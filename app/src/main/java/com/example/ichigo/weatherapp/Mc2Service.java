package com.example.ichigo.weatherapp;

import com.example.ichigo.weatherapp.models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Mc2Service {

    @GET("/forecast")
    Call<WeatherData> getWeatherInfo (@Query("lat") String latitude,
                                      @Query("lon") String longitude,
                                      @Query("cnt") String cnt,
                                      @Query("appid") String appid);
}
