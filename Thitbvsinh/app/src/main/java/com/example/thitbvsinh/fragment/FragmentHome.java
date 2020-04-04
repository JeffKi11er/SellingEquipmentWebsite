package com.example.thitbvsinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.adapter.AdapterPagerAdvertise;
import com.google.android.material.tabs.TabLayout;

public class FragmentHome extends FragmentPage {
    private ImageView imgAdvertiseLarge;
    private ImageView imgKitchen;
    private ImageView imgComboKit;
    private ImageView imgToilet;
    private ImageView imgWashing;
    private TabLayout tabAdvertise;
    private ViewPager viewPager;
    private TextView tvDevice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        imgAdvertiseLarge = view.findViewById(R.id.img_adhuge);
        imgKitchen = view.findViewById(R.id.img_bep);
        imgComboKit = view.findViewById(R.id.img_combo_bep);
        imgToilet = view.findViewById(R.id.img_toilet);
        imgWashing = view.findViewById(R.id.img_chau);
        tvDevice = view.findViewById(R.id.tv_device);
        tabAdvertise = view.findViewById(R.id.tab_advertise);
        viewPager = view.findViewById(R.id.view_advertise);
        viewPager.setAdapter(new AdapterPagerAdvertise(getChildFragmentManager()));
        tabAdvertise.setupWithViewPager(viewPager);
        return view;
    }
}
