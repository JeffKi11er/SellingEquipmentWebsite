package com.t3h.myprojectnote.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.t3h.myprojectnote.R;
import com.t3h.myprojectnote.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Item> data = new ArrayList<>();

    public ListViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public ListViewAdapter(ArrayList<Item> data) {
        this.data = data;
    }

//    public void setData(List<Item> data) {
//        this.data = data;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View v = inflater.inflate(R.layout.new_event_calendar,viewGroup,false);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_event_calendar,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        Item item = data.get(i);
//        viewHolder.bindData(item);
        viewHolder.tvtime.setText(data.get(i).getTime());
        viewHolder.tvnameEvent.setText(data.get(i).getTitle());
        viewHolder.tvdate.setText(data.get(i).getDate());
        viewHolder.tveventDescrip.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvdate;
        private TextView tvtime;
        private TextView tvnameEvent;
        private TextView tveventDescrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdate = itemView.findViewById(R.id.tv_date_item);
            tvtime = itemView.findViewById(R.id.tv_time);
            tvnameEvent = itemView.findViewById(R.id.tv_title);
            tveventDescrip = itemView.findViewById(R.id.tv_address);
        }

        public void bindData(Item item) {
            tvdate.setText(item.getDate());
            tvtime.setText(item.getTime());
            tveventDescrip.setText(item.getDescription());
            tvnameEvent.setText(item.getTitle());
        }
    }
}
