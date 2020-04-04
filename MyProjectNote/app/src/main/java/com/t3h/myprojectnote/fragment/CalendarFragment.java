package com.t3h.myprojectnote.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.t3h.myprojectnote.R;
import com.t3h.myprojectnote.customview.CalendarView;

public class CalendarFragment extends BaseFragment {
    CalendarView calendarView;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.calendar_fragment_layout,container,false);
//        calendarView  = (CalendarView)v.findViewById(R.id.carlendar_custom);
//        Log.e(getClass().getName(),"onCreateView");
//        return v;
//    }
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        calendarView  = findViewById(R.id.carlendar_custom_calender);
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout custmview = (LinearLayout)getActivity().findViewById(R.id.carlendar_custom_calender);
        custmview.addView(new CalendarView(getActivity(),null));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(),"onDestroy");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.calendar_fragment_layout;
    }
}
