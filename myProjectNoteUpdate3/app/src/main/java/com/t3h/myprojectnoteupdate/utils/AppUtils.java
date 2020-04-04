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
//    public static Date getSettingDateTime(String y, String m, String d){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Integer.parseInt(y), Integer.parseInt(m)-1, Integer.parseInt(d));//calendar.set(y, m, d);
//        Date date = calendar.getTime();
//        return date;
//    }

    public static String getFormattedDateString(Date date){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            String dateString = simpleDateFormat.format(date);
            Date newDate = simpleDateFormat.parse(dateString);
            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm ss");
            return simpleDateFormat.format(newDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    public static String getFormattedDate2String(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("yyyy.MMMMM.dd 'T' hh:mm aaa");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
////    }
//    public static String getFormattedDayString(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm a");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static String getFormattedDayStringShow(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static String getFormattedTimeStringMenu(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm a");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("HH:mm ");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static String getFormattedTimeString(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm a");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("HH:mm a");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public static String getFormattedTimeStringShow(Date date){
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
//            String dateString = simpleDateFormat.format(date);
//            Date newDate = simpleDateFormat.parse(dateString);
//            simpleDateFormat = new SimpleDateFormat("HH:mm");
//            return simpleDateFormat.format(newDate);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
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
//    public static Date ConvertStringToDate(String date){
//        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm a");
//        Date date1 = null;
//        try{
//            date1 = format.parse(date);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return date1;
//    }
//    public static Date ConvertStringToDate2(String date){
//        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
//        Date date1 = null;
//        try{
//            date1 = format.parse(date);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return date1;
//    }
}
