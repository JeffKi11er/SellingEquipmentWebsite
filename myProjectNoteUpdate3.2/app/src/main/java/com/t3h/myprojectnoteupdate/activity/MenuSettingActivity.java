package com.t3h.myprojectnoteupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.t3h.myprojectnoteupdate.AppConstants;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.SettingAdapter;
import com.t3h.myprojectnoteupdate.databinding.SettingLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.settingmodel.ModelSetting;
import com.t3h.myprojectnoteupdate.utils.NavigatorUtils;

import java.util.ArrayList;

public class MenuSettingActivity extends AppCompatActivity implements View.OnClickListener, AppConstants {
    private final String TAG = "MenuSettingActivity";
    public static final String TITLE = "title.menu";
    public static final String CONTENT = "content.menu";
    private ImageView imgNextMoveColor,imgNextMoveSound,imgNextMoveRepeat,imgNextMoveDate,imgNextMoveTime;
    private TextView tvColor,tvSound,tvRepeat,tvDate,tvTime;
    private ImageView imgColor;
    private TextView tvsoundname,tvreapeatminutes,tvdatepick,tvtimepick;
    private TextView tvtitle;
    private TextView btndone;
    private ImageView imgclose;
    private Item item;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        init();
    }

    private void init() {
//        Intent intent = getIntent();
//        String title = intent.getStringExtra(EditNewActivity.TITLE);
//        String content = intent.getStringExtra(EditNewActivity.CONTENT);
//        intent.putExtra(TITLE,title);
//        intent.putExtra(CONTENT,content);
        tvtitle = findViewById(R.id.title);
        tvtitle.setText(R.string.title_menu_setting);

        imgclose = findViewById(R.id.btn_close);
        imgclose.setOnClickListener(this);
        imgclose.setImageResource(R.drawable.ic_arrowback);
        imgclose.setTag(R.drawable.ic_arrowback);

        btndone = findViewById(R.id.btn_done);

        imgColor = findViewById(R.id.img_color_show);

        imgNextMoveColor = findViewById(R.id.img_next_color);
        imgNextMoveColor.setOnClickListener(this);

        imgNextMoveDate = findViewById(R.id.img_next_date);
        imgNextMoveDate.setOnClickListener(this);

        imgNextMoveTime = findViewById(R.id.img_next_time);
        imgNextMoveTime.setOnClickListener(this);

        imgNextMoveSound = findViewById(R.id.img_next_sound);
        imgNextMoveSound.setOnClickListener(this);

        imgNextMoveRepeat = findViewById(R.id.img_next_repeat);
        imgNextMoveRepeat.setOnClickListener(this);

        tvsoundname = findViewById(R.id.tv_sound_content);
        tvreapeatminutes = findViewById(R.id.tv_repeat_content);
        tvdatepick = findViewById(R.id.tv_date_content);
        tvtimepick = findViewById(R.id.tv_time_content);
        item = (Item)getIntent().getSerializableExtra(INTENT_TASK);
    }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
//                Intent intent = new Intent(this,EditNewActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//                intent.putExtra(INTENT_TASK,item);
////                setResult(RESULT_OK);
//                startActivity(intent);
//                NavigatorUtils.redirectToViewNoteScreen(this,item);
                finish();
                overridePendingTransition(R.anim.stay,R.anim.slide_down);
                break;
//            case R.id.btn_done:
//                Intent intent = getIntent();
        }

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
