package com.t3h.baovip;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivMenu;
    NavigationView nv;
    DrawerLayout draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMenu = findViewById(R.id.iv_menu);
        draw = findViewById(R.id.drawable);
        nv = findViewById(R.id.nv);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.openDrawer(nv);
            }
        });


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_content, new FragmentPage())
                .commit();

    }
}
