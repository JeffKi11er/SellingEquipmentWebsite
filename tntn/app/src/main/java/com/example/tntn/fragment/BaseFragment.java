package com.example.tntn.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tntn.MainActivity;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutRes(),container,false);
        return v;
    }
    protected <T extends View> T findViewById(@IdRes int id){
        return getActivity().findViewById(id);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(getClass().getName(),"onActivityCreated");
    }

    protected abstract int getLayoutRes();

    public abstract String getTitle();

    protected MainActivity getParent(){
        return (MainActivity)getActivity();
    }

    @Override
    public void onDestroy() {
        Log.e(getClass().getName(),"onDestroy");
        super.onDestroy();
    }
}
