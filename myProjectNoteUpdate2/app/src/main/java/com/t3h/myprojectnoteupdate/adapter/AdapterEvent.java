package com.t3h.myprojectnoteupdate.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.t3h.myprojectnoteupdate.BR;
import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.item.Item;
import com.t3h.myprojectnoteupdate.item.ItemEvent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<AdapterEvent.ViewHolder> {
    //private @LayoutRes int resId;
    private LayoutInflater inflater;
    private List<Item>data;
   // private ListItemListener listener;

    public AdapterEvent(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v = inflater.inflate(R.layout.new_event_calendar,viewGroup,false);
//       ViewDataBinding binding = DataBindingUtil.inflate(inflater,resId,viewGroup,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item t = data.get(i);
       viewHolder.setBinding(t);

    }


    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTime;
        TextView tvDate;
        TextView tvTitle;
        TextView tvDescrip;
        public ViewHolder(@NonNull View view) {
            super(view);
            tvTime = view.findViewById(R.id.tv_time);
            tvDate= view.findViewById(R.id.tv_date_item);
            tvTitle = view.findViewById(R.id.tv_title);
            tvDescrip = view.findViewById(R.id.tv_address);
        }
        public void setBinding(Item item){
            tvDate.setText(item.getDate());
            tvDescrip.setText(item.getDescription());
            tvTime.setText(item.getTime());
            tvTitle.setText(item.getTitle());
        }
    }
//    public interface ListItemListener{}
}
