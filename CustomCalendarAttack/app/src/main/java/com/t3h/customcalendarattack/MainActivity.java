package com.t3h.customcalendarattack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CustomCalendarView customViewCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customViewCalendar = (CustomCalendarView) findViewById(R.id.custom_calendar);
    }
}
