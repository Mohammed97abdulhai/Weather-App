package com.example.ichigo.weatherapp.models;


import com.example.ichigo.weatherapp.models.City;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {

    private City city;
    private String cod;
    private String message;
    private Integer cnt;
    private java.util.List<List> list = new ArrayList<List>();

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

}
