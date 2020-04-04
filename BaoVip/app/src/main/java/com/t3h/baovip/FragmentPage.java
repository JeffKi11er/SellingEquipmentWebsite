package com.t3h.baovip;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by GiangVien T3H on 12/27/2019.
 */

public class FragmentPage extends Fragment {
    private TabLayout tab;
    private ViewPager vp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        tab = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);
        vp.setAdapter(new PagerAdapter(getChildFragmentManager()));
        tab.setupWithViewPager(vp);
        return view;

    }
}
