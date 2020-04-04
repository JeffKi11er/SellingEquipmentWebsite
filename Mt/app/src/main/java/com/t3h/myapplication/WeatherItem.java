package com.t3h.myapplication;

public class WeatherItem {
    private String day;
    private String status;
    private String image;
    private String maxTemp;
    private String minTemp;

    public WeatherItem(String day, String status, String image, String maxTemp, String minTemp) {
        this.day = day;
        this.status = status;
        this.image = image;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }
}
