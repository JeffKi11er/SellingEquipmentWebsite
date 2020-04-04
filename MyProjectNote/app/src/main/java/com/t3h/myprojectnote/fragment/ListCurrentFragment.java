package com.t3h.myprojectnote.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.t3h.myprojectnote.MainActivity;
import com.t3h.myprojectnote.R;
import com.t3h.myprojectnote.adapter.ListViewAdapter;
import com.t3h.myprojectnote.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ListCurrentFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView rcveventCurrent;
    private FloatingActionButton flbuttadd;
    private ArrayList<Item> data = new ArrayList<>();
    private ListViewAdapter adapter;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.currentevent_layout,container, false);
//        Log.e(getClass().getName(),"onCreateView");
//        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbarlayout);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        rcveventCurrent = (RecyclerView) v.findViewById(R.id.lv_event_current);
//        flbuttadd = (FloatingActionButton)v.findViewById(R.id.btn_addeventcurrent);
//        return v;
//    }

    @Override
    protected int getLayoutRes() {
        return R.layout.currentevent_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlayout);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        rcveventCurrent = (RecyclerView) findViewById(R.id.lv_event_current);
        flbuttadd = (FloatingActionButton)findViewById(R.id.btn_addeventcurrent);
        //rcveventCurrent.setAdapter(adapter);
        flbuttadd.setOnClickListener(this);
        getData();
        initfakeInfo();
    }

    public void getData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        rcveventCurrent.setLayoutManager(linearLayoutManager);
        adapter = new ListViewAdapter(data);
        rcveventCurrent.setAdapter(adapter);
    }
    private void initfakeInfo(){
        for (int i = 0; i <10 ; i++) {
            Item item = new Item();
            item.setTitle("title $"+ i);
            item.setDate("July 14th, 2019");
            item.setTime("03:00");
            item.setDescription("descrip $"+i);
            data.add(item);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(),"onDestroy");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_calendar_bar:
                MainActivity activity = (MainActivity)getActivity();
                activity.showFragment(activity.getCalendarFragment());
                break;
            case R.id.app_search_bar:
                Toast.makeText(getActivity(),"appSearch",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        MainActivity activity1 = (MainActivity)getActivity();
        activity1.showFragment(activity1.getAddnewEventFragment());

    }
}
