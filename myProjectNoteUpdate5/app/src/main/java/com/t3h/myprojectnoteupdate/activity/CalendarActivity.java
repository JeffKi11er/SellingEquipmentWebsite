package com.t3h.myprojectnoteupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.myprojectnoteupdate.AppConstants;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.customview.CalendarView;
import com.t3h.myprojectnoteupdate.databinding.CalendarActivityLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.respository.NoteRespository;
import com.t3h.myprojectnoteupdate.utils.NavigatorUtils;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener, AppConstants {
    private final String TAG = "CalendarActivity";
    private ImageView imgclose;
    private TextView tvtitlebar,tvdone;
    private CalendarView calendarView;
    private FloatingActionButton btnadd;
    private Item item;
    private NoteRespository noteRespository;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity_layout);
        noteRespository = new NoteRespository(getApplicationContext());
        init();
    }

    private void init() {
        calendarView = (CalendarView)findViewById(R.id.carlendar_custom_calender);
        tvtitlebar = findViewById(R.id.title);

        btnadd = findViewById(R.id.btn_add_calendar_event);
        btnadd.setOnClickListener(this);

        tvdone = findViewById(R.id.btn_done);

        imgclose = findViewById(R.id.btn_close);
        imgclose.setOnClickListener(this);
        //item = (Item)getIntent().getSerializableExtra(INTENT_TASK);
        tvtitlebar.setText(R.string.title_calendar);
        imgclose.setImageResource(R.drawable.ic_arrowback);
        imgclose.setTag(R.drawable.ic_arrowback);
        tvdone.setText("");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                setResult(Activity.RESULT_CANCELED);
                finish();
                overridePendingTransition(R.anim.stay,R.anim.slide_down);
                break;
            case R.id.btn_add_calendar_event:
                //NavigatorUtils.redirectToViewNoteScreen(this,item);
                Intent intent = new Intent(this,EditNewActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//                intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//                startActivityForResult(intent,2);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.stay,R.anim.slide_down);
                break;
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
//    @Override
//    protected int getLayoutId() {
//        return R.layout.calendar_activity_layout;
//    }


}
