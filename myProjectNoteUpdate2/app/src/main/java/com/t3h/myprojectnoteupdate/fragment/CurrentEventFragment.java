package com.t3h.myprojectnoteupdate.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.activity.EditNewActivity;
import com.t3h.myprojectnoteupdate.adapter.AdapterEvent;
import com.t3h.myprojectnoteupdate.appdatabase.Appdatabase;
import com.t3h.myprojectnoteupdate.customview.CalendarView;
import com.t3h.myprojectnoteupdate.databinding.CurrenteventLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CurrentEventFragment extends BaseFragment<CurrenteventLayoutBinding> implements View.OnClickListener {
    private List<Item> data;
    private AdapterEvent adapterEvent;
    private SimpleDateFormat simpleDateFormat;
    private String time;
    private Context context;
    public static final String CURRENT_EXTRA_DATE = "current.extra.date";
    @Override
    protected int getLayoutId() {
        return R.layout.currentevent_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        biding.btnAddeventcurrent.setOnClickListener(this);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        adapterEvent = new AdapterEvent(getContext());
        biding.lvEventCurrent.setAdapter(adapterEvent);
        getData();
    }

    public void getData() {
        data = Appdatabase.getInstance(getContext()).getItemDao().getAll();
        adapterEvent.setData(data);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), EditNewActivity.class);
        Calendar calendar = Calendar.getInstance();
        time = simpleDateFormat.format(calendar.getTime());
        intent.putExtra(time, CURRENT_EXTRA_DATE);

        startActivity(intent);
    }
}
