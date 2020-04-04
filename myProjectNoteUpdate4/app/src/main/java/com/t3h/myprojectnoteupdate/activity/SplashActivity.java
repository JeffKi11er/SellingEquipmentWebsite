package com.t3h.myprojectnoteupdate.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.ybq.android.spinkit.SpinKitView;
import com.t3h.myprojectnoteupdate.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SpinKitView spinKitView = findViewById(R.id.spin_kit);
        final RelativeLayout relativeLayout = findViewById(R.id.rl_logo);
//        editSearch.setInputType(InputType.TYPE_NULL);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 1000);

    }
}
