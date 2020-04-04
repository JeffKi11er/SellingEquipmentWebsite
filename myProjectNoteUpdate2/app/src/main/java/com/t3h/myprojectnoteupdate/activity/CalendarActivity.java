package com.t3h.myprojectnoteupdate.activity;

import android.support.v7.app.ActionBar;
import android.util.Log;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.databinding.CalendarActivityLayoutBinding;

public class CalendarActivity extends BaseActivity<CalendarActivityLayoutBinding> {
    private final String TAG = "CalendarActivity";
    @Override
    protected void initAct() {
        Log.v(TAG,"onCreate");
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("");
        actionBar2.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.calendar_activity_layout;
    }


}
