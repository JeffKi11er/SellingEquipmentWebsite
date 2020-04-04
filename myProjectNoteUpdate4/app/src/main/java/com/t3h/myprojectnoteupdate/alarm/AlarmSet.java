package com.t3h.myprojectnoteupdate.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.t3h.myprojectnoteupdate.receiver.MyAlarm;

public class AlarmSet {
    public static void setAlarm(Activity activity, long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager)activity.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(activity, MyAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(activity,0,intent,0);
        alarmManager.setRepeating(AlarmManager.RTC,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(activity,"It's set",Toast.LENGTH_SHORT).show();
    }
}
