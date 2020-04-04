package com.example.thitbvsinh.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.thitbvsinh.fragment.FragmentContact;
import com.example.thitbvsinh.fragment.FragmentHome;
import com.example.thitbvsinh.fragment.FragmentPickup;
import com.example.thitbvsinh.fragment.FragmetSale;

public class AdapterPager extends FragmentPagerAdapter {
    public AdapterPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment result;
        switch (position){
            case 0 :
                result = new FragmentHome();
                break;
            case 1 :
                result = new FragmentPickup();
                break;
            case 2 :
                result = new FragmetSale();
                break;
            default:
                result = new FragmentContact();
                break;
        }
        return result;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Trang chủ";
        }
        if(position==1){
            return "Giỏ hàng (0)";
        }
        if(position==2){
            return "Khuyến mãi";
        }
        return "Liên hệ";
    }
}
