package com.t3h.myprojectnote.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.t3h.myprojectnote.R;
import com.t3h.myprojectnote.customview.CustomEditNote;

public class AddnewEventFragment extends BaseFragment {
    CustomEditNote customEditNote;
    Toolbar toolbar;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.news_events_layout,container,false);
//        Log.e(getClass().getName(),"onCreateView");
//        return v;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_event:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.news_events_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ConstraintLayout custmaddview = (ConstraintLayout)getActivity()
                .findViewById(R.id.custom_note) ;
        custmaddview.addView(new CustomEditNote(getActivity(),null));
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarseclayout);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ConstraintLayout custmaddview = (ConstraintLayout)getActivity()
//                .findViewById(R.id.custom_note) ;
//        custmaddview.addView(new CustomEditNote(getActivity(),null));
//        toolbar =findViewById(R.id.toolbarseclayout);
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getName(),"onDestroy");
    }
}
