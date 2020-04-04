package com.example.demofirebase;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demofirebase.databinding.ItemChatBinding;

import java.util.ArrayList;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ViewHolder> {
    private ArrayList<Chat>data;
    private LayoutInflater inflater;
    private ItemClickListener listener;
    public AdapterChat(Context context){
        this.inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Chat> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemChatBinding binding = ItemChatBinding.inflate(inflater);
        return new ViewHolder(binding);
    }
    public void setListener(ItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.setItem(data.get(i));
        viewHolder.binding.setListener(listener);
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemChatBinding binding;
        public ViewHolder(ItemChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface ItemClickListener{
        void onItemClick(Chat chat);
    }
}
