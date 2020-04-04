package com.t3h.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Main2Activity extends AppCompatActivity {
    ImageView imgback;
    ListView lsweather;
    TextView tvName;
    String namecity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String city = intent.getStringExtra("name");
        Log.d("result","data : "+city);
        if(city.equals("")){
            namecity ="Haiphong";
            Get7dayData(namecity);
        }else{
            namecity=city;
            Get7dayData(namecity);
        }
        init();
    }

    private void init() {
        imgback = (ImageView)findViewById(R.id.img_back);
        lsweather = (ListView)findViewById(R.id.listview);
        tvName = (TextView)findViewById(R.id.tv_namecity);

    }

    private void Get7dayData(String data) {
        String url = "api.openweathermap.org/data/2.5/forecast/daily?q="+data+"&mode=xml&units=metric&cnt=7";
        RequestQueue requestQueue = Volley.newRequestQueue(Main2Activity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
