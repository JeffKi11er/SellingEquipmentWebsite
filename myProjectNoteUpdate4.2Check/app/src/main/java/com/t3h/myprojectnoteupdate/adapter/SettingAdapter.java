package com.t3h.myprojectnoteupdate.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.activity.SettingActivity;
import com.t3h.myprojectnoteupdate.settingmodel.ModelSetting;

import java.util.ArrayList;
import java.util.List;

public class SettingAdapter {//extends BaseAdapter {
//    Context ncontext;
//    LayoutInflater inflater;
//    List<ModelSetting>modelSettings;
//    ArrayList<ModelSetting>arrayList;
//
//    public SettingAdapter(Context context,List<ModelSetting> modelSettings) {
//        ncontext = context;
//        this.modelSettings = modelSettings;
//        inflater = LayoutInflater.from(ncontext);
//        this.arrayList = new ArrayList<ModelSetting>();
//        this.arrayList.addAll(modelSettings);
//
//    }
//    public class ViewHolder{
//        TextView tvtitle, tvInfo;
//    }
//    @Override
//    public int getCount() {
//        return modelSettings.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return modelSettings.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if(convertView ==null){
//            holder = new ViewHolder();
//            convertView = inflater.inflate(R.layout.tool_setting,null);
//            holder.tvInfo = convertView.findViewById(R.id.tv_tool);
//            holder.tvtitle = convertView.findViewById(R.id.tv_infom);
//            convertView.setTag(holder);
//
//        }else {
//            holder = (ViewHolder)convertView.getTag();
//        }
//        holder.tvtitle.setText(modelSettings.get(position).getTitle());
//        holder.tvInfo.setText(modelSettings.get(position).getDescrip());
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(modelSettings.get(position).getTitle().equals("Color")){
//                    Intent intent = new Intent(ncontext, SettingActivity.class);
//                    intent.putExtra("actionBarTitle","Color");
//                    intent.putExtra("contentitem","");
//                    ncontext.startActivity(intent);
//                }
//                if(modelSettings.get(position).getTitle().equals("Sound")){
//                    Intent intent = new Intent(ncontext, SettingActivity.class);
//                    intent.putExtra("actionBarTitle","Sound");
//                    intent.putExtra("contentitem","");
//                    ncontext.startActivity(intent);
//                }
//                if(modelSettings.get(position).getTitle().equals("Date")){
//                    Intent intent = new Intent(ncontext, SettingActivity.class);
//                    intent.putExtra("actionBarTitle","Date");
//                    intent.putExtra("contentitem","");
//                    ncontext.startActivity(intent);
//                }
//                if(modelSettings.get(position).getTitle().equals("Time")){
//                    Intent intent = new Intent(ncontext, SettingActivity.class);
//                    intent.putExtra("actionBarTitle","Time");
//                    intent.putExtra("contentitem","");
//                    ncontext.startActivity(intent);
//                }
//                if(modelSettings.get(position).getTitle().equals("Repeat")){
//                    Intent intent = new Intent(ncontext, SettingActivity.class);
//                    intent.putExtra("actionBarTitle","Repeat");
//                    intent.putExtra("contentitem","");
//                    ncontext.startActivity(intent);
//                }
//            }
//        });
//        return convertView;
//    }

}
