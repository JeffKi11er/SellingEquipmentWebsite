package com.t3h.myprojectnoteupdate.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppUtils {
    public static Date getCurrentDateTime(){
        Date currentDate = Calendar.getInstance().getTime();
        return currentDate;
    }
    public static String getFormattedDateString(Date date){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            String dateString = simpleDateFormat.format(date);
            Date newDate = simpleDateFormat.parse(dateString);
            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy 'T' HH:mm");
            return simpleDateFormat.format(newDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void openKeyboard(final Context context){
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager inputMethodManager =
                        (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null){
                    inputMethodManager
                            .toggleSoftInput(InputMethodManager
                            .SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
            }
        },500);
    }
    public static void hideKeyboard(Activity activity){
        InputMethodManager inputMethodManager =
                (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);
    }
}
