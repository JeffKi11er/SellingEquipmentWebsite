package com.t3h.myprojectnoteupdate.activity;

import android.app.Activity;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;

import com.t3h.myprojectnoteupdate.AppConstants;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.SettingAdapter;
import com.t3h.myprojectnoteupdate.databinding.SettingLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.settingmodel.ModelSetting;
import com.t3h.myprojectnoteupdate.utils.AppUtils;
import com.t3h.myprojectnoteupdate.utils.NavigatorUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MenuSettingActivity extends AppCompatActivity implements AppConstants {
    private final String TAG = "MenuSettingActivity";
//    public static String TITLE = "title.menu";
//    public static String CONTENT = "content.menu";
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
        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        final String content = intent.getStringExtra("content");
        final String date = intent.getStringExtra("date");
//        final Date date1 = AppUtils.ConvertStringToDate(date);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date date2 = format.parse(date);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        String formattedDate = formatter.format(date1);
//        String title = intent.getStringExtra(EditNewActivity.TITLE);
//        String content = intent.getStringExtra(EditNewActivity.CONTENT);
//        intent.putExtra(TITLE,title);
//        intent.putExtra(CONTENT,content);
        tvtitle = findViewById(R.id.title);
        tvtitle.setText(R.string.title_menu_setting);

        imgclose = findViewById(R.id.btn_close);
        imgclose.setImageResource(R.drawable.ic_arrowback);
        imgclose.setTag(R.drawable.ic_arrowback);
        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
                overridePendingTransition(R.anim.stay,R.anim.slide_down);
            }
        });

        btndone = findViewById(R.id.btn_done);
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Title",title);
                intent.putExtra("Content",content);
                intent.putExtra("Date",date);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        imgColor = findViewById(R.id.img_color_show);

        imgNextMoveColor = findViewById(R.id.img_next_color);
        imgNextMoveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgNextMoveDate = findViewById(R.id.img_next_date);
        imgNextMoveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgNextMoveTime = findViewById(R.id.img_next_time);
        imgNextMoveTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int minuts = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(imgNextMoveTime.getContext(), R.style.MyDialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar1.set(Calendar.MINUTE,minute);
                        calendar1.setTimeZone(TimeZone.getDefault());
                        Date date11 = calendar1.getTime();
                        SimpleDateFormat hfomate = new SimpleDateFormat("K:mm a");
                        String eventTime = hfomate.format(date11);
                        SimpleDateFormat hfo = new SimpleDateFormat("HH:mm");
                        String[]timePicker = hfo.format(date11).split(":",2);
                        //date1.setHours(Integer.parseInt(timePicker[0]));
                        //date1.setMinutes(Integer.parseInt(timePicker[1]));
                        tvtimepick.setText(eventTime);
                    }
                },hours,minuts,false);
                timePickerDialog.show();
            }

        });

        imgNextMoveSound = findViewById(R.id.img_next_sound);
        imgNextMoveSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgNextMoveRepeat = findViewById(R.id.img_next_repeat);
        imgNextMoveRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvsoundname = findViewById(R.id.tv_sound_content);
        tvreapeatminutes = findViewById(R.id.tv_repeat_content);
        tvdatepick = findViewById(R.id.tv_date_content);
        tvtimepick = findViewById(R.id.tv_time_content);
//        item = (Item)getIntent().getSerializableExtra(INTENT_TASK);
//        if(item!=null) {
//            tvdatepick.setText(AppUtils.getFormattedDayStringShow(item.getCreatedAt()));
//            tvtimepick.setText(AppUtils.getFormattedTimeString(item.getCreatedAt()));
//        }
//        else
//            tvdatepick.setText(date1.getDate()+" "+date1.getMonth()+" , "+date1.getYear());
//            tvtimepick.setText(date1.getHours()+":"+date1.getMinutes());
//            String TITLE = getIntent().getStringExtra(INTENT_TITLE);
//            String CONTENT = getIntent().getStringExtra(INTENT_DESCRIPT);
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

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.img_next_date:
//                break;
//            case R.id.img_next_time:
//                final Calendar calendar = Calendar.getInstance();
//                int hours = calendar.get(Calendar.HOUR_OF_DAY);
//                int minuts = calendar.get(Calendar.MINUTE);
//                TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.MyDialogTheme,
//                        new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                                Calendar calendar1 = Calendar.getInstance();
//                                calendar1.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                                calendar1.set(Calendar.MINUTE,minute);
//                                calendar.setTimeZone(TimeZone.getDefault());
//                                SimpleDateFormat hfomate = new SimpleDateFormat("K:mm a");
//                                String eventTime = hfomate.format(calendar1.getTime());
//                                tvtimepick.setText(eventTime);
//
//                            }
//                        },hours,minuts,false);
//                timePickerDialog.show();
//                break;
//            case R.id.btn_close:
////                Intent intent = new Intent(this,EditNewActivity.class);
////                intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
////                intent.putExtra(INTENT_TASK,item);
//                setResult(Activity.RESULT_CANCELED);
////                startActivity(intent);
////                NavigatorUtils.redirectToViewNoteScreen(this,item);
//                finish();
//                overridePendingTransition(R.anim.stay,R.anim.slide_down);
//                break;
//            case R.id.btn_done:
////                Intent intent = getIntent();
//////                Intent intent1 = new Intent(this,EditNewActivity.class);
//////                intent1.putExtra(INTENT_TASK,item);
////                setResult(Activity.RESULT_OK,intent);
//////                startActivity(intent1);
////                finish();
////                overridePendingTransition(R.anim.stay,R.anim.slide_down);
////                Intent intent = getIntent();
////                if (intent != null) {
//////                    String[]dates = tvDate.getText().toString().split(" ",3);
//////                    String[]times = tvTime.getText().toString().split(":",2);
//////                    item.setCreatedAt(AppUtils.getSettingDateTime(dates[2],dates[1],dates[0],times[0],times[1]));
//////                    item.setModifiedAt(AppUtils.getSettingDateTime(dates[2],dates[1],dates[0],times[0],times[1]));
////                    intent.putExtra(INTENT_TASK,item);
////                    setResult(Activity.RESULT_OK,intent);
////                    finish();
////                }
////                else {
////                    finish();
////                    overridePendingTransition(R.anim.stay, R.anim.slide_down);
////                }
//                Intent intent = new Intent();
//                intent.putExtra("title",title);
//                break;
//        }

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

