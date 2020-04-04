package com.t3h.myprojectnoteupdate.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity <BD extends ViewDataBinding>extends AppCompatActivity {
    protected BD biding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biding = DataBindingUtil.setContentView(this,getLayoutId());
        initAct();
    }
    protected abstract void initAct();
    protected abstract int getLayoutId();
}
