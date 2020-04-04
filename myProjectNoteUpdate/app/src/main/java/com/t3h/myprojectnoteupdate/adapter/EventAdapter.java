package com.t3h.myprojectnoteupdate.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.t3h.myprojectnoteupdate.BR;
import com.t3h.myprojectnoteupdate.EventModel;

import java.util.ArrayList;

public class EventAdapter<T extends EventModel>extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private @LayoutRes int resId;
    private LayoutInflater layoutInflater;
    private ArrayList<T> data;
    private ListItemListener listener;

    public void setListener(ListItemListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<T> getData() {
        return data;
    }

    public EventAdapter(Context context, int resId) {
        this.resId = resId;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater,resId,viewGroup,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder viewHolder, int i) {
        T t = data.get(i);
        viewHolder.binding.setVariable(BR.item,t);
        //viewHolder.binding.setVariable(BR.listener,listener);
        viewHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public  interface ListItemListener{

    }
}
