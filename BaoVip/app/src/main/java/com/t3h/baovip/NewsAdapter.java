package com.t3h.baovip;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private List<ItemDataNew> datas;

    public NewsAdapter(List<ItemDataNew> datas) {
        this.datas = datas;
    }

    public List<ItemDataNew> getDatas() {
        return datas;
    }

    public void setDatas(List<ItemDataNew> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(
                R.layout.item_new,
                parent,
                false
        );
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        ItemDataNew item = datas.get(position);
        holder.tvContent.setText(item.getContent());
        holder.tvTitle.setText(item.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(item.getLinkImage())
//                .error(R.drawable.ao_dai)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        if ( datas == null){
            return 0;
        }
        return datas.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder{
        ImageView ivAvatar;
        TextView tvTitle;
        TextView tvContent;
        public NewsHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
