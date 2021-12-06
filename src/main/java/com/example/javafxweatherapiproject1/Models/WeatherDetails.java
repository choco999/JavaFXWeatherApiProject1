package com.example.javafxweatherapiproject1.Models;

import java.util.ArrayList;

public class WeatherDetails {
    private ArrayList<Weather> weather;
    private Main main;
    private Clouds clouds;

    public WeatherDetails(ArrayList<Weather> weather, Main main, Clouds clouds) {
        this.weather = weather;
        this.main = main;
        this.clouds = clouds;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
}
