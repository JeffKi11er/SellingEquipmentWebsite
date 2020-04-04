package com.t3h.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtSearch;
    Button btnSearch, btnChangeActivity;
    TextView tvName, tvNation, tvTemp, tvStatus, tvHumidity, tvCloud, tvWind, tvDays;
    ImageView imgIcon;
    String City="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        GetCurrentWeatherData("Haiphong");
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                if(city.equals("")){
                    City = "Haiphong";
                    GetCurrentWeatherData(City);
                }else {///nếu edittext tồn tại thì sẽ lấy giá trị đó
                    City = city;
                    GetCurrentWeatherData(City);
                }
                GetCurrentWeatherData(city);
            }
        });
        btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",city);
                startActivity(intent);
            }
        });
    }

    private void init() {
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        btnChangeActivity = findViewById(R.id.btn_nextday);
        tvCloud = (TextView) findViewById(R.id.tv_cloud);
        tvStatus = (TextView) findViewById(R.id.tv_state);
        tvDays = (TextView) findViewById(R.id.tv_day);
        tvWind = (TextView) findViewById(R.id.tv_wind);
        tvHumidity = (TextView) findViewById(R.id.tv_humidity);
        tvName = (TextView) findViewById(R.id.tv_nameCity);
        tvNation = (TextView) findViewById(R.id.tv_nameNation);
        tvTemp = (TextView) findViewById(R.id.tv_degree);
        imgIcon = (ImageView)findViewById(R.id.img_icon);
    }
    public void GetCurrentWeatherData(String data){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&appid=a9601557ab43f17c70d2b2efd34c89ab";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d("result",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String day = jsonObject.getString("dt");
                            String name = jsonObject.getString("name");
                            tvName.setText("Name of City : "+name);
                            //chuyển dữ liệu dạng unique
                            long l = Long.valueOf(day);
                            //chuyển dữ liệu từ mini giây sang day
                            Date date = new Date(l*1000L);
                            SimpleDateFormat simpleDateFormat =
                                    new SimpleDateFormat("EEEE yyyy-MM-dd HH-mm-ss");
                            ///tạo một biến ứng với dữ liệu vừa mới format
                            String Day = simpleDateFormat.format(date);
                            tvDays.setText(Day);
                            JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
                            //tạo json object cho json object trong jsonArray
                            //JsonArray lấy dữ liệu từ JsonObject
                            JSONObject jsonObjectweather = jsonArrayWeather.getJSONObject(0);
                            String status = jsonObjectweather.getString("main");
                            String icon = jsonObjectweather.getString("icon");
                            Picasso.with(MainActivity.this).load("http://openweathermap.org/img/wn/"+icon
                            +".png").into(imgIcon);
                            tvStatus.setText(status);
                            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                            String temperature = jsonObjectMain.getString("temp");
                            String huminity_ = jsonObjectMain.getString("humidity");
                            Double a = Double.valueOf(temperature);
                            ///chuyển kiểu cho biến nhiệt độ này thành chuỗi
                            String Temper = String.valueOf(a.intValue());
                            tvTemp.setText(Temper+" Celsius");
                            tvHumidity.setText(huminity_+ " %");
                            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                            String speed_ = jsonObjectWind.getString("speed");
                            tvWind.setText(speed_+ " m/s");
                            JSONObject jsonObjectCloud = jsonObject.getJSONObject("clouds");
                            String cloud_ = jsonObjectCloud.getString("all");
                            tvCloud.setText(cloud_+" %");
                            JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
                            String nation = jsonObjectSys.getString("country");
                            tvNation.setText("Name of country : "+nation);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });///truyền 4 tham số : khai báo trả về bằng kiểu int, đường truyền để
        //truy cập vào URI, 1 cái action listener để trả về những giá trị mà nó đã đọc được, báo lỗi nếu k đc gửi
        requestQueue.add(request);
    }
    @Override
    public void onClick(View view) {

    }
}
