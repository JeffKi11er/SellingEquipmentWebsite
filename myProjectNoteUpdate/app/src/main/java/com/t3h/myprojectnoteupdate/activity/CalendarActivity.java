package com.t3h.myprojectnoteupdate.activity;

import android.support.v7.app.ActionBar;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.databinding.CalendarActivityLayoutBinding;

public class CalendarActivity extends BaseActivity<CalendarActivityLayoutBinding> {
    @Override
    protected void initAct() {
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("");
        actionBar2.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.calendar_activity_layout;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
