package com.t3h.myprojectnoteupdate.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.AdapterNewEvent;
import com.t3h.myprojectnoteupdate.appdatabase.Appdatabase;
import com.t3h.myprojectnoteupdate.check.ValidatorUtils;
import com.t3h.myprojectnoteupdate.databinding.NewsEventsLayoutBinding;
import com.t3h.myprojectnoteupdate.fragment.CurrentEventFragment;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.sharedhelper.SharedHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.validation.Validator;

public class EditNewActivity extends BaseActivity<NewsEventsLayoutBinding> {
    private final String TAG = "EditNewActivity";
    public static final String UPDATE_EXTRA_DATE = "extra.update.date";
    public static final String YES_NO = "yes.no";
    private SharedHelper sharedHelper;
//    List<String>listString= Arrays.asList("   ","   ","   ","   ","   ","   "
//            ,"   ","   ","   ","   ","   ","   ");
    //AdapterNewEvent adapterNewEvent;
    //RecyclerView recyclerView;
//    boolean band = true;
    private Item item;
    @Override
    protected void initAct() {
        Log.v(TAG,"onCreate");
        sharedHelper = new SharedHelper(this);
        String title = sharedHelper.get(SharedHelper.Keys.TITLE,null);
        String descrip = sharedHelper.get(SharedHelper.Keys.DESCRIP,null);
        String date = sharedHelper.get(SharedHelper.Keys.DATE,null);
        String time = sharedHelper.get(SharedHelper.Keys.TIME,null);
        if(!TextUtils.isEmpty(title)&&!TextUtils.isEmpty(descrip)){
            startMainActivity();
            return;
        }
        ActionBar actionBar3 = getSupportActionBar();
        actionBar3.setTitle("New Note");///co thay doi khi click vao item
        actionBar3.setDisplayHomeAsUpEnabled(true);
        //LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        //recyclerView.setLayoutManager(llm);
//        Intent intent = getIntent();
//        intent.putExtra(CurrentEventFragment.CURRENT_EXTRA_DATE,UPDATE_EXTRA_DATE);
        //adapterNewEvent = new AdapterNewEvent(listString);
        //recyclerView.setAdapter(adapterNewEvent);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.check_add){
            startActivitySetting();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startActivitySetting() {
//        String[]escrit = adapterNewEvent.getEscri();
//        for (int i = 0; i < escrit.length; i++) {
//            if (escrit[i]==null){
//                band = false;
//                return;
//            }else {
//                if (escrit[i].equals("")) {
//                    band = false;
//                    return;
//                }
//            }
//        }
//        if (band){
//            for (int i = 0;i<escrit.length;i++){
//
//            }
//        }
        if(ValidatorUtils.isInputEmpty(biding.edtDescrp,biding.edtTitle)){
            return;
        }
        String title = biding.edtTitle.getText().toString();
        String descrip=biding.edtDescrp.getText().toString();
        String []times = UPDATE_EXTRA_DATE.split("T",2);
        String date = times[0];
        String time = times[1];
        boolean isInsert = false;
        sharedHelper.set(SharedHelper.Keys.TITLE,title);
        sharedHelper.set(SharedHelper.Keys.DESCRIP,descrip);
        sharedHelper.set(SharedHelper.Keys.DATE,date);
        sharedHelper.set(SharedHelper.Keys.TIME,time);
        if(item==null){
            item = new Item();
        }
//        item.setDate(date);
//        item.setDescription(descrip);
//        item.setTime(time);
//        item.setTitle(title);
//        if (isInsert){
//            Appdatabase.getInstance(this).getItemDao().insert(item);
//        }else {
//            Appdatabase.getInstance(this).getItemDao().update(item);
//        }
        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra(title,MainActivity.REQUEST_TITLE);
//        intent.putExtra(descrip,MainActivity.REQUEST_DESCRIPT);
//        intent.putExtra(date,MainActivity.REQUEST_DATE);
//        intent.putExtra(time,MainActivity.REQUEST_TIME);
        startActivity(intent);
//        intent.putExtra("1",MainActivity.REQUEST_TRUE);
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

    @Override
    protected int getLayoutId() {
        return R.layout.news_events_layout;
    }
    public void setItem(Item item){
        this.item = item;
        if (item != null){
            biding.edtTitle.setText(item.getTitle());
            biding.edtDescrp.setText(item.getDescription());
            item.setTime(item.getTime());
            item.setDate(item.getDate());
        }else{
            biding.edtTitle.setText("");
            biding.edtDescrp.setText("");
        }
    }
}
