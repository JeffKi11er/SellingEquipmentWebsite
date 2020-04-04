package com.example.tntn.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tntn.News;
import com.example.tntn.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    
    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item_view,viewGroup,false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        News item = data.get(i);
        newsHolder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        private ImageView imgNews;
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPubdate;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.img_news);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_decs);
            tvPubdate = itemView.findViewById(R.id.tv_date);
        }

        public void bindData(final News item) {
            tvTitle.setText(item.getTitle());
            tvPubdate.setText(item.getPubDate());
            tvDesc.setText(item.getDesc());
            Glide.with(imgNews)
                    .load(item.getImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imgNews);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(item.getLink()));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
