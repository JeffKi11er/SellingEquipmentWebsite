package com.example.thitbvsinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.adapter.AdapterPagerAdvertise;
import com.google.android.material.tabs.TabLayout;

public class FragmentAdvertisePage extends FragmentPage {
    private TabLayout tabAdvertise;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_advertise,container,false);
        tabAdvertise = v.findViewById(R.id.tab_advertise);
        viewPager = v.findViewById(R.id.view_advertise);
        viewPager.setAdapter(new AdapterPagerAdvertise(getChildFragmentManager()));
        tabAdvertise.setupWithViewPager(viewPager);
        return v;
    }
}
