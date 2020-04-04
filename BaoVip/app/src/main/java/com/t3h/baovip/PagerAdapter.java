package com.t3h.baovip;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by GiangVien T3H on 12/27/2019.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentContent content = new FragmentContent();
        if (position == 0){
            content.setLink("https://www.24h.com.vn");
        }else {
            if ( position == 1){
                content.setLink("https://www.24h.com.vn/tin-tuc-quoc-te-c415.html");
            }else {
                content.setLink("https://www.24h.com.vn/bong-da-c48.html");
            }
        }

        return content;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Khám phá";
        }
        if (position == 1){
            return "Tin mới";
        }
        return "Tin hot";
    }
}
