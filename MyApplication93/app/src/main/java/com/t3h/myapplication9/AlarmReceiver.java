package com.t3h.myapplication9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "ALARM ON", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, RingtonePlayingService.class);
        context.startService(intent1);

    }
}
