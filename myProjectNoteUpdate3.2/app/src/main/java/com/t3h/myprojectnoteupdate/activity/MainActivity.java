package com.t3h.myprojectnoteupdate.activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.t3h.myprojectnoteupdate.AppConstants;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.AdapterEvent;
import com.t3h.myprojectnoteupdate.databinding.ActivityMainBinding;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.respository.NoteRespository;
import com.t3h.myprojectnoteupdate.utils.NavigatorUtils;
import com.t3h.myprojectnoteupdate.utils.RecycleItemClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RecycleItemClickListener.OnRecycleViewItemClickListener, AppConstants {
    private final String TAG = "MainActivity";
//    public static final String REQUEST_DATE = "item.date";
//    public static final String REQUEST_TIME = "item.time";
//    public static final String REQUEST_TRUE = "string.boolean";
//    public static final String REQUEST_TITLE = "item.title";
//    public static final String REQUEST_DESCRIPT = "item.description";
//    private CurrentEventFragment currentEventFragment = new CurrentEventFragment();
    boolean right = true;
    private Item item;
    private EditText editSearch;
    private ImageView btnCalendar;
    private RecyclerView recylerlist;
    private AdapterEvent adapterEvent;
    private FloatingActionButton actionButton;
    private NoteRespository noteRespository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"MainActivity");
        setContentView(R.layout.activity_main);
        noteRespository = new NoteRespository(getApplicationContext());
        recylerlist = findViewById(R.id.lv_event_current);
        recylerlist.addOnItemTouchListener(new RecycleItemClickListener(this, this));
        actionButton = findViewById(R.id.btn_addeventcurrent);
        actionButton.setOnClickListener(this);
        editSearch = findViewById(R.id.edt_search);
        btnCalendar = findViewById(R.id.btn_calendar);
        btnCalendar.setOnClickListener(this);
        
        updateTaskList();
    }

    private void updateTaskList() {
        noteRespository.getTasks().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                    if(adapterEvent==null){
                        adapterEvent = new AdapterEvent(items);
                        recylerlist.setAdapter(adapterEvent);
                    }else adapterEvent.addTask(items);
            }
        });
    }

    //    @Override
//    protected void initAct() {
//        Log.v(TAG,"onCreate");
////        ActionBar actionBar = getSupportActionBar();
////        actionBar.setTitle("CalendarView");
////        setSupportActionBar(biding.toolbar);
////        showFragment(currentEventFragment);
//        biding.btnAddeventcurrent.setOnClickListener(this);
////        Intent intent = getIntent();
////        String date = intent.getStringExtra(REQUEST_DATE);
////        String time = intent.getStringExtra(REQUEST_TIME);
////        String title = intent.getStringExtra(REQUEST_TITLE);
////        String descrip = intent.getStringExtra(REQUEST_DESCRIPT);
////        if(date!=""&&time!=""&&title!=""&&descrip!=""){
////            getCurrentEventFragment().getData();
////        }
////        intent.putExtra(REQUEST_DATE,"");
////        intent.putExtra(REQUEST_DESCRIPT,"");
////        intent.putExtra(REQUEST_TIME,"");
////        intent.putExtra(REQUEST_TITLE,"");
//    }
//
////    public void showFragment(Fragment fm) {
////        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////        transaction.replace(R.id.panel,fm);
////        transaction.runOnCommit(new Runnable() {
////            @Override
////            public void run() {
////                Log.e(getClass().getName(),"runOnCommit");
////            }
////        });
////        transaction.commitAllowingStateLoss();
////    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu_main,menu);
////        SearchView searchView = (SearchView)menu.findItem(R.id.app_bar_search).getActionView();
//////        searchView.setOnQueryTextListener(this);
//////        searchView.setOnQueryTextFocusChangeListener(this);
////
////        return super.onCreateOptionsMenu(menu);
////    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_main;
//    }
//
////    public CurrentEventFragment getCurrentEventFragment() {
////        return currentEventFragment;
////    }
//
////    @Override
////    public boolean onQueryTextSubmit(String s) {
////        Toast.makeText(this,"SearchSuccess",Toast.LENGTH_SHORT).show();
////        return false;
////    }
////
////    @Override
////    public boolean onQueryTextChange(String s) {
////        biding.lvTest.setVisibility(View.VISIBLE);
////        return false;
////    }
////
////    @Override
////    public void onFocusChange(View v, boolean hasFocus) {
////        if(!hasFocus){
////            biding.lvTest.setVisibility(View.GONE);
////        }
////    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        if(item.getItemId()==R.id.app_caledar_bar){
////            startMainActivity();
////        }
////        return super.onOptionsItemSelected(item);
////    }
//
//    private void startMainActivity() {
//        Intent intent = new Intent(this,CalendarActivity.class);
//        startActivity(intent);
//       // finish();
//    }
///add new note
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addeventcurrent:
                Intent intent = new Intent(this,EditNewActivity.class);
                startActivityForResult(intent,ACTIVITY_REQUEST_CODE);
            break;
            case R.id.btn_calendar:
                Intent intent1 = new Intent(this,CalendarActivity.class);
                startActivityForResult(intent1,ACTIVITY_REQUEST_CODE);
        }
    }

    @Override
    public void onItemClick(View parentView, View childView, int position) {
        Item item = adapterEvent.getItem(position);
        NavigatorUtils.redirectToEditTaskScreen(this,item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ACTIVITY_REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            if (data.hasExtra(INTENT_TASK)){
                if (data.hasExtra(INTENT_DELETE)){
                    noteRespository.deleteTask((Item)data.getSerializableExtra(INTENT_TASK));
                }else {
                    noteRespository.updateTask((Item)data.getSerializableExtra(INTENT_TASK));
                }

            }
            else {
                String title = data.getStringExtra(INTENT_TITLE);
                String desc = data.getStringExtra(INTENT_DESCRIPT);
                ///Calendar Needs
                noteRespository.insertTask(title,desc);
            }
            updateTaskList();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
