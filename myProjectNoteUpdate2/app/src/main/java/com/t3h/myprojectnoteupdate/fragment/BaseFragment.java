package com.t3h.myprojectnoteupdate.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<BD extends ViewDataBinding> extends Fragment {
    protected BD biding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        biding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        return biding.getRoot();
    }
    protected abstract int getLayoutId();
}
