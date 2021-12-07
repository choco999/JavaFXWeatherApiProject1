package com.example.javafxweatherapiproject1.Models;

public class Coord {
    private float lon;
    private float lat;

    public Coord(float lon, float lat) {
        setLon(lon);
        setLat(lat);
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
