package com.t3h.myprojectnoteupdate.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.SettingAdapter;
import com.t3h.myprojectnoteupdate.databinding.SettingLayoutBinding;
import com.t3h.myprojectnoteupdate.settingmodel.ModelSetting;

import java.util.ArrayList;

public class MenuSettingActivity extends AppCompatActivity {
    private final String TAG = "MenuSettingActivity";
    ListView listView;
    SettingAdapter settingAdapter;
    String[]title;
    String[]info;
//    ArrayList<ModelSetting>arrayList = new ArrayList<>();
//    @Override
//    protected void initAct() {
//        ActionBar actionBar4 = getSupportActionBar();
//        setTitle("Detail");
//        actionBar4.setDisplayHomeAsUpEnabled(true);
//        title = new String[]{"Color","Sound","Date","Time","Repeat"};
//        info = new String[]{"","","","",""};
//        for (int i = 0; i< title.length;i++){
//            ModelSetting modelSetting = new ModelSetting(title[i],info[i]);
//            arrayList.add(modelSetting);
//
//        }
//        settingAdapter = new SettingAdapter(this,arrayList);
//        biding.lvTool.setAdapter(settingAdapter);
//    }
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_setting,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    protected int getLayoutId() {
//        return R.layout.setting_layout;
//    }
}
