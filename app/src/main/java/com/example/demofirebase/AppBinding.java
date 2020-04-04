package com.example.demofirebase;

import android.databinding.BindingAdapter;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class AppBinding {
    @BindingAdapter("item")
    public static void setTime(){
        SimpleDateFormat time = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    }
}
