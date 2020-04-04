package com.t3h.myprojectnote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.t3h.myprojectnote.customview.CalendarView;
import com.t3h.myprojectnote.fragment.AddnewEventFragment;
import com.t3h.myprojectnote.fragment.CalendarFragment;
import com.t3h.myprojectnote.fragment.ListCurrentFragment;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    private ListCurrentFragment listCurrentFragment = new ListCurrentFragment();
    private CalendarFragment calendarFragment = new CalendarFragment();
    private AddnewEventFragment addnewEventFragment = new AddnewEventFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbarlayout);
//        setSupportActionBar(toolbar);
        showFragment(listCurrentFragment);
        //calendarView  = (CalendarView)findViewById(R.id.carlendar_custom);
    }

    public void showFragment(Fragment fm) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.replace(R.id.panel,fm);
        transaction.runOnCommit(new Runnable() {
            @Override
            public void run() {
                Log.e(getClass().getName(),"runOnCommit");
            }
        });
        transaction.commitAllowingStateLoss();
    }

    public ListCurrentFragment getListCurrentFragment() {
        return listCurrentFragment;
    }

    public CalendarFragment getCalendarFragment() {
        return calendarFragment;
    }

    public AddnewEventFragment getAddnewEventFragment() {
        return addnewEventFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.app_calendar_bar:
//                Toast.makeText(this,"Show Calendar",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.app_search_bar:
//                Toast.makeText(this,"Search event",Toast.LENGTH_LONG).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
