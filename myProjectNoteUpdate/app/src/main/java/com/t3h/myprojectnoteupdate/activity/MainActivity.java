package com.t3h.myprojectnoteupdate.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.t3h.myprojectnoteupdate.ItemListener;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.databinding.ActivityMainBinding;
import com.t3h.myprojectnoteupdate.fragment.CurrentEventFragment;
import com.t3h.myprojectnoteupdate.item.Item;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding>implements SearchView.OnQueryTextListener, View.OnFocusChangeListener, ItemListener<Item> {
    public static final String REQUEST_DATE = "item.date";
    public static final String REQUEST_MONTH = "item.month";
    public static final String REQUEST_YEAR = "item.year";
    private CurrentEventFragment currentEventFragment = new CurrentEventFragment();
    private List<Item>data;

    @Override
    protected void initAct() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("CalendarView");
//        setSupportActionBar(biding.toolbar);
        showFragment(currentEventFragment);
    }

    public void showFragment(Fragment fm) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.panel,fm);
        transaction.runOnCommit(new Runnable() {
            @Override
            public void run() {
                Log.e(getClass().getName(),"runOnCommit");
            }
        });
        transaction.commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        SearchView searchView = (SearchView)menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setOnQueryTextFocusChangeListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public CurrentEventFragment getCurrentEventFragment() {
        return currentEventFragment;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Toast.makeText(this,"SearchSuccess",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        biding.lvTest.setVisibility(View.VISIBLE);
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
            biding.lvTest.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.app_caledar_bar){
            startMainActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this,CalendarActivity.class);
        startActivity(intent);
//        finish();
    }

    @Override
    public void onItemClick(Item item) {

    }
}
