package com.example.javafxweatherapiproject1.Models;

public class Wind {
    private float speed;
    private int deg;
    private float gust;

    public Wind(float speed, int deg, float gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public float getGust() {
        return gust;
    }

    public void setGust(float gust) {
        this.gust = gust;
    }
}
