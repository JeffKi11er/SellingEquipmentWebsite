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

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.databinding.ActivityMainBinding;
import com.t3h.myprojectnoteupdate.fragment.CurrentEventFragment;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.sharedhelper.SharedHelper;

public class MainActivity extends BaseActivity<ActivityMainBinding>{
    private final String TAG = "MainActivity";
    public static final String REQUEST_DATE = "item.date";
    public static final String REQUEST_TIME = "item.time";
    public static final String REQUEST_TRUE = "string.boolean";
    public static final String REQUEST_TITLE = "item.title";
    public static final String REQUEST_DESCRIPT = "item.description";
    private CurrentEventFragment currentEventFragment = new CurrentEventFragment();
    boolean right = true;
    private Item item;
    private SharedHelper sharedHelper;
    @Override
    protected void initAct() {
        Log.v(TAG,"onCreate");
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("CalendarView");
//        setSupportActionBar(biding.toolbar);
        //showFragment(currentEventFragment);
//        sharedHelper.get(SharedHelper.Keys.TITLE,"");
//        sharedHelper.get(SharedHelper.Keys.DESCRIP,"");
//        sharedHelper.get(SharedHelper.Keys.TIME,"");
//        sharedHelper.get(SharedHelper.Keys.DATE,"");
//        if (item==null){
//            item = new Item();
//        }

//        Intent intent = getIntent();
//        String date = intent.getStringExtra(REQUEST_DATE);
//        String time = intent.getStringExtra(REQUEST_TIME);
//        String title = intent.getStringExtra(REQUEST_TITLE);
//        String descrip = intent.getStringExtra(REQUEST_DESCRIPT);
//        if(date!=""&&time!=""&&title!=""&&descrip!=""){
//            getCurrentEventFragment().getData();
//        }
//        intent.putExtra(REQUEST_DATE,"");
//        intent.putExtra(REQUEST_DESCRIPT,"");
//        intent.putExtra(REQUEST_TIME,"");
//        intent.putExtra(REQUEST_TITLE,"");
    }

//    public void showFragment(Fragment fm) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.panel,fm);
//        transaction.runOnCommit(new Runnable() {
//            @Override
//            public void run() {
//                Log.e(getClass().getName(),"runOnCommit");
//            }
//        });
//        transaction.commitAllowingStateLoss();
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
////        SearchView searchView = (SearchView)menu.findItem(R.id.app_bar_search).getActionView();
////        searchView.setOnQueryTextListener(this);
////        searchView.setOnQueryTextFocusChangeListener(this);
//
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

//    public CurrentEventFragment getCurrentEventFragment() {
//        return currentEventFragment;
//    }

//    @Override
//    public boolean onQueryTextSubmit(String s) {
//        Toast.makeText(this,"SearchSuccess",Toast.LENGTH_SHORT).show();
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String s) {
//        biding.lvTest.setVisibility(View.VISIBLE);
//        return false;
//    }
//
//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//        if(!hasFocus){
//            biding.lvTest.setVisibility(View.GONE);
//        }
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==R.id.app_caledar_bar){
//            startMainActivity();
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void startMainActivity() {
        Intent intent = new Intent(this,CalendarActivity.class);
        startActivity(intent);
       // finish();
    }

}
