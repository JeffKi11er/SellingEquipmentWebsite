package com.t3h.myprojectnoteupdate.activity;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.databinding.NewsEventsLayoutBinding;
import com.t3h.myprojectnoteupdate.utils.ValidatorUtils;

public class EditNewActivity extends BaseActivity<NewsEventsLayoutBinding>{
    @Override
    protected void initAct() {
        ActionBar actionBar3 = getSupportActionBar();
        actionBar3.setTitle("New Note");///co thay doi khi click vao item
        actionBar3.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==R.id.app_edit_barcheck){
//            if(!ValidatorUtils.isImputEmpty(biding.edtTitle)){
//            }
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.news_events_layout;
    }

}
