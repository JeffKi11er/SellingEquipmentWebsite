package com.example.thitbvsinh.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.thitbvsinh.fragment.FragmentNewProduct;
import com.example.thitbvsinh.fragment.FragmentSaleProduct;
import com.example.thitbvsinh.fragment.FragmentTrendProduct;

public class AdapterPagerAdvertise extends FragmentPagerAdapter {
    public AdapterPagerAdvertise(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment result;
        switch (position){
            case 0:
                result = new FragmentNewProduct();
                break;
            case 1:
                result = new FragmentTrendProduct();
                break;
            default:
                result = new FragmentSaleProduct();
                break;
        }
        return result;
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Sản phẩm mới";
        }if (position==1){
            return "Sản phẩm bán chạy";
        }
        return "Đang giảm giá";
    }
}
