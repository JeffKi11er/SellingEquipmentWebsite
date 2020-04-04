package com.t3h.myprojectnoteupdate.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import com.t3h.myprojectnoteupdate.item.ItemSong;

import java.util.ArrayList;

public class MyAlarm extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    private ArrayList<ItemSong>arrsong;
    private Context context;
    private int currentIndex;
    private int getInt;

    public MyAlarm(ArrayList<ItemSong> arrsong, Context context) {
        this.arrsong = arrsong;
        this.context = context;
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
//        Bundle bundle = intent.getBundleExtra("received");
//        getInt = bundle.getInt("index");
//        createNew(getInt);
        mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();
    }

    public void createNew(int index) {
        String data = arrsong.get(index).getData();
        mediaPlayer = MediaPlayer.create(context, Uri.parse(data));
        start();
    }

    private void start() {
        mediaPlayer.start();
    }
}
