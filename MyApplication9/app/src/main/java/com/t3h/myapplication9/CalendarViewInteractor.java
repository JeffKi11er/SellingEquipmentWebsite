package com.t3h.myapplication9;

import android.content.Context;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by francescofurlan on 03/07/17.
 */

public class CalendarViewInteractor implements ViewInteractor {
    private Context context;
    private Calendar calendar;
    private TextView firstDaySelectedTxt;
    private TextView lastDaySelectedTxt;

    CalendarViewInteractor(Context context) {
        this.context = context;
    }

    @Override
    public void onCustomizableCalendarBindView(View view) {

    }

    @Override
    public void onHeaderBindView(ViewGroup view) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.calendar_header, view);
        firstDaySelectedTxt = (TextView) layout.findViewById(R.id.first_day_selected);
        lastDaySelectedTxt = (TextView) layout.findViewById(R.id.last_day_selected);
        updateCalendar(calendar);
    }

    @Override
    public void onWeekDaysBindView(View view) {

    }

    @Override
    public void onWeekDayBindView(WeekDaysViewAdapter.WeekDayVH holder, String weekDay) {

    }

    @Override
    public void onSubViewBindView(View view, String month) {

    }

    @Override
    public void onCalendarBindView(View view) {

    }

    @Override
    public void onMonthBindView(View view) {

    }

    @Override
    public View onMonthCellBindView(View view, CalendarItem currentItem) {
        return null;
    }

    @Override
    public boolean hasImplementedDayCalculation() {
        return false;
    }

    @Override
    public List<CalendarItem> calculateDays(int year, int month, int firstDayOfMonth, int lastDayOfMonth) {
        return null;
    }

    @Override
    public boolean hasImplementedSelection() {
        return false;
    }

    @Override
    public int setSelected(boolean multipleSelection, DateTime dateSelected) {
        return -1;
    }

    @Override
    public boolean hasImplementedMonthCellBinding() {
        return false;
    }

    @Override
    public View getMonthGridView(View rootView) {
        return null;
    }

    @Override
    public boolean hasImplementedWeekDayNameFormat() {
        return false;
    }

    @Override
    public String formatWeekDayName(String nameOfDay) {
        return null;
    }

    void updateCalendar(Calendar calendar) {
        this.calendar = calendar;
        if (firstDaySelectedTxt != null && lastDaySelectedTxt != null) {
            DateTime firstDate = calendar.getFirstSelectedDay();
            DateTime lastDate = calendar.getLastSelectedDay();
            if (firstDate != null) {
                firstDaySelectedTxt.setText(firstDate.toString("dd MMMMM yyyy"));
            }
            if (lastDate != null) {
                lastDaySelectedTxt.setText(lastDate.toString("dd MMMMM yyyy"));
            }
        }
    }
}
