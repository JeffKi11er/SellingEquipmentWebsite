package com.t3h.myprojectnoteupdate.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.t3h.myprojectnoteupdate.R;
import com.t3h.myprojectnoteupdate.activity.FlickrShowActivity;
import com.t3h.myprojectnoteupdate.item.ItemFlickr;

import java.util.List;

public class ItemFlickrAdapter extends RecyclerView.Adapter<ItemFlickrAdapter.MyHolder> {
    private Context context;
    private List<ItemFlickr>itemFlickrs;

    public ItemFlickrAdapter(Context context, List<ItemFlickr> itemFlickrs) {
        this.context = context;
        this.itemFlickrs = itemFlickrs;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_flickr,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.imgV.setImageResource(itemFlickrs.get(i).getThumb());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlickrShowActivity.class);
                intent.putExtra("Thumb",itemFlickrs.get(i).getThumb());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemFlickrs.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        ImageView imgV;
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgV = itemView.findViewById(R.id.img);
            cardView = (CardView) itemView.findViewById(R.id.cardV);
        }
    }
}
