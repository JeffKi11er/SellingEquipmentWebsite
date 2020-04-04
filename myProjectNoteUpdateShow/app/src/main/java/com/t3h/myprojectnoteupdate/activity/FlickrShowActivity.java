package com.t3h.myprojectnoteupdate.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import com.t3h.myprojectnoteupdate.R;

public class FlickrShowActivity extends AppCompatActivity {
    ImageView imgv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flickractivity);
        Intent intent = getIntent();
        int image = intent.getExtras().getInt("Thumb");
        imgv = (ImageView)findViewById(R.id.img_item);
        imgv.setImageResource(image);
    }
}
