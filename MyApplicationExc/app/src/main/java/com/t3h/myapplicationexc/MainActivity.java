package com.t3h.myapplicationexc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_CALENDAR_DAYS = 42;
    LinearLayout calendar_header;
    ImageButton button_prev;
    ImageButton button_next;
    TextView tv_day;
    TextView tv_date;
    TextView tv_year;
    Button button_today;
    GridView calendar_table;
    List<Date> dates = new ArrayList<>();
    Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    GridAdapter gridAdapter;
    List<CalendarContract.Events>events = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setUpCalendar();
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,-1);
                setUpCalendar();
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,1);
                setUpCalendar();
            }
        });
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

    private void setUpCalendar() {
        String currentDate = dateFormat.format(calendar.getTime());
        tv_date.setText(currentDate);
        dates.clear();
        Calendar monthCalendar = (Calendar)calendar.clone();
        monthCalendar.set(Calendar.DAY_OF_MONTH,1);
        int fistDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK)-2;
        monthCalendar.add(Calendar.DAY_OF_MONTH,-fistDayOfMonth);
        while (dates.size()<MAX_CALENDAR_DAYS){
            dates.add(monthCalendar.getTime());
            monthCalendar.add(Calendar.DAY_OF_MONTH,1);
        }
        gridAdapter = new GridAdapter(this,dates,calendar,events);
        calendar_table.setAdapter(gridAdapter);
    }

    private void init() {
        calendar_header = findViewById(R.id.calender_header);
        button_next = findViewById(R.id.calendar_nextbutton);
        button_prev = findViewById(R.id.calendar_previous);
        tv_date = findViewById(R.id.jv_date);
        calendar_table = findViewById(R.id.calender_days);
    }
}
