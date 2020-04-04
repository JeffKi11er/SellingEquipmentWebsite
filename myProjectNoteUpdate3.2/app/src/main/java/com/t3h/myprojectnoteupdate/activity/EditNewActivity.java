package com.t3h.myprojectnoteupdate.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.myprojectnoteupdate.AppConstants;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.adapter.AdapterNewEvent;
import com.t3h.myprojectnoteupdate.appdatabase.Appdatabase;
import com.t3h.myprojectnoteupdate.check.ValidatorUtils;
import com.t3h.myprojectnoteupdate.customview.CustomViewNoteOriginal;
import com.t3h.myprojectnoteupdate.databinding.NewsEventsLayoutBinding;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.utils.AppUtils;
import com.t3h.myprojectnoteupdate.utils.NavigatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditNewActivity extends AppCompatActivity implements View.OnClickListener, AppConstants {
    public static final int REQUEST_BACK =1;
    public static final String TITLE = "title.backstack";
    public static final String CONTENT = "content.backstack";
    private final String TAG = "EditNewActivity";
    private ImageView imgclose;
    private TextView tvtitle;
    private TextView btndone;
    private EditText edtTitle;
    private TextView tvdate;
    private ImageView imgDetail;
    private CustomViewNoteOriginal edtCustomContent;
//    public static final String UPDATE_EXTRA_DATE = "extra.update.date";
//    public static final String YES_NO = "yes.no";
//    List<String>listString= Arrays.asList("   ","   ","   ","   ","   ","   "
//            ,"   ","   ","   ","   ","   ","   ");
    //AdapterNewEvent adapterNewEvent;
    //RecyclerView recyclerView;
//    boolean band = true;
    private Item item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_events_layout);
        init();
    }

    private void init() {
        tvtitle = findViewById(R.id.title);
        edtCustomContent = (CustomViewNoteOriginal) findViewById(R.id.edt_descrp);
        edtTitle = findViewById(R.id.edtTitle);
        tvdate = findViewById(R.id.tv_time_edtnote);

        imgclose = findViewById(R.id.btn_close);
        imgclose.setOnClickListener(this);

        btndone = findViewById(R.id.btn_done);
        btndone.setOnClickListener(this);

        imgDetail = findViewById(R.id.img_detail);
        imgDetail.setOnClickListener(this);

        item = (Item) getIntent().getSerializableExtra(INTENT_TASK);
        if (item == null) {
            tvtitle.setText(getString(R.string.title_edit_note));
            imgclose.setImageResource(R.drawable.btn_done);
            imgclose.setTag(R.drawable.btn_done);
            tvdate.setText(AppUtils.getFormattedDateString(AppUtils.getCurrentDateTime()));
        } else {
            tvtitle.setText(getString(R.string.title_edit_note_edit));
            imgclose.setImageResource(R.drawable.ic_delete);
            imgclose.setTag(R.drawable.ic_delete);
            if (item.getTitle() != null && !item.getTitle().isEmpty()) {
                edtTitle.setText(item.getTitle());
                edtTitle.setSelection(edtTitle.getText().length());
            }
            if (item.getDescription() != null && !item.getDescription().isEmpty()) {
                edtCustomContent.setText(item.getDescription());
                edtCustomContent.setSelection(edtCustomContent.getText().length());
            }
            if (item.getCreatedAt() != null) {
                tvdate.setText(AppUtils.getFormattedDateString(item.getCreatedAt()));
            }
        }
        AppUtils.openKeyboard(getApplicationContext());
    }

    //    @Override
//    protected void initAct() {
//        Log.v(TAG,"onCreate");
//        ActionBar actionBar3 = getSupportActionBar();
//        actionBar3.setTitle("New Note");///co thay doi khi click vao item
//        actionBar3.setDisplayHomeAsUpEnabled(true);
        //LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        //recyclerView.setLayoutManager(llm);
//        Intent intent = getIntent();
//        intent.putExtra(CurrentEventFragment.CURRENT_EXTRA_DATE,UPDATE_EXTRA_DATE);
        //adapterNewEvent = new AdapterNewEvent(listString);
        //recyclerView.setAdapter(adapterNewEvent);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_add,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==R.id.check_add){
//            startActivitySetting();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    private void startActivitySetting() {
////        String[]escrit = adapterNewEvent.getEscri();
////        for (int i = 0; i < escrit.length; i++) {
////            if (escrit[i]==null){
////                band = false;
////                return;
////            }else {
////                if (escrit[i].equals("")) {
////                    band = false;
////                    return;
////                }
////            }
////        }
////        if (band){
////            for (int i = 0;i<escrit.length;i++){
////
////            }
////        }
//        if(ValidatorUtils.isInputEmpty(biding.edtDescrp,biding.edtTitle)){
//            return;
//        }
//        String title = biding.edtTitle.getText().toString();
//        String descrip=biding.edtDescrp.getText().toString();
//        String []times = UPDATE_EXTRA_DATE.split("T",2);
//        String date = times[0];
//        String time = times[1];
//        boolean isInsert = false;
//
////        if(item==null){
////            item = new Item();
////        }
////        item.setDate(date);
////        item.setDescription(descrip);
////        item.setTime(time);
////        item.setTitle(title);
////        if (isInsert){
////            Appdatabase.getInstance(this).getItemDao().insert(item);
////        }else {
////            Appdatabase.getInstance(this).getItemDao().update(item);
////        }
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra(title,MainActivity.REQUEST_TITLE);
//        intent.putExtra(descrip,MainActivity.REQUEST_DESCRIPT);
//        intent.putExtra(date,MainActivity.REQUEST_DATE);
//        intent.putExtra(time,MainActivity.REQUEST_TIME);
//        startActivity(intent);
////        intent.putExtra("1",MainActivity.REQUEST_TRUE);
//    }


    @Override
    public void onClick(View v) {
        AppUtils.hideKeyboard(this);
        if (v == imgclose){
            if ((Integer)imgclose.getTag()==R.drawable.btn_done){
                setResult(Activity.RESULT_CANCELED);
            }else {
                Intent intent = getIntent();
                intent.putExtra(INTENT_DELETE,true);
                intent.putExtra(INTENT_TASK,item);
                setResult(Activity.RESULT_OK,intent);
            }
            finish();
            overridePendingTransition(R.anim.stay, R.anim.slide_down);
        }else if (v == btndone){
            if(ValidatorUtils.isInputEmpty(edtCustomContent,edtTitle)){
            return;
       }
            Intent intent = getIntent();
            if (item!=null){
                item.setTitle(edtTitle.getText().toString());
                item.setDescription(edtCustomContent.getText().toString());
                intent.putExtra(INTENT_TASK,item);
            }else {
                intent.putExtra(INTENT_TITLE,edtTitle.getText().toString());
                intent.putExtra(INTENT_DESCRIPT,edtCustomContent.getText().toString());
            }
            setResult(Activity.RESULT_OK,intent);
            finish();
            overridePendingTransition(R.anim.stay,R.anim.slide_down);
        }else if(v==imgDetail){
            Intent intent = new Intent(this, MenuSettingActivity.class);
//            String title = edtTitle.getText().toString();
//            String content = edtCustomContent.getText().toString();
//            intent.putExtra(TITLE,title);
////            intent.putExtra(CONTENT,content);
//            intent.putExtra(INTENT_TITLE,edtTitle.getText().toString());
//            intent.putExtra(INTENT_DESCRIPT,edtCustomContent.getText().toString());
//            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
            //startActivityForResult(intent,REQUEST_BACK);
            startActivity(intent);
            //finish();
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
//        return R.layout.news_events_layout;
//    }
//    public void setItem(Item item){
//        this.item = item;
//        if (item != null){
//            biding.edtTitle.setText(item.getTitle());
//            biding.edtDescrp.setText(item.getDescription());
//            item.setTime(item.getTime());
//            item.setDate(item.getDate());
//        }else{
//            biding.edtTitle.setText("");
//            biding.edtDescrp.setText("");
//        }
//    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==REQUEST_BACK){
//            if (resultCode==Activity.RESULT_OK){
//                String title = data.getStringExtra(MenuSettingActivity.TITLE);
//                String content = data.getStringExtra(MenuSettingActivity.CONTENT);
//                edtTitle.setText(title);
//                edtCustomContent.setText(content);
//            }
//        }
//    }
}
