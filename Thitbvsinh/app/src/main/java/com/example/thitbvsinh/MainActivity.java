package com.example.thitbvsinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thitbvsinh.fragment.FragmentPage;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMovInfo;
    private TextView tvMovEmail;
    private EditText edSearch;
    private ImageView btnSearch;
    private ImageView btnLogo;
    private TextView tvSignIn;
    private TextView tvSignUp;
    private DrawerLayout drawlayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        drawlayout = findViewById(R.id.draw);
        navigationView = findViewById(R.id.navigationView);
        tvMovInfo = findViewById(R.id.tv_masquee);
        tvMovEmail = findViewById(R.id.tv_email);
        tvMovInfo.setSelected(true);
        tvMovEmail.setSelected(true);
        edSearch = findViewById(R.id.edt_search);
        btnLogo = findViewById(R.id.img_logo);
        btnSearch = findViewById(R.id.img_search_butt);
        tvSignIn = findViewById(R.id.tv_signin);
        tvSignUp = findViewById(R.id.tv_signup);
        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawlayout.openDrawer(navigationView);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentPage()).commit();
    }
}
