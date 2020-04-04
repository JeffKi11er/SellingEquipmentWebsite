package com.t3h.myprojectnoteupdate.fragment;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.activity.EditNewActivity;
import com.t3h.myprojectnoteupdate.adapter.EventAdapter;
import com.t3h.myprojectnoteupdate.databinding.CurrenteventLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;

public class CurrentEventFragment extends BaseFragment<CurrenteventLayoutBinding> implements View.OnClickListener {
    private EventAdapter<Item>adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.currentevent_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        biding.btnAddeventcurrent.setOnClickListener(this);
        biding.lvEventCurrent.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), EditNewActivity.class);
        startActivity(intent);
    }
}
