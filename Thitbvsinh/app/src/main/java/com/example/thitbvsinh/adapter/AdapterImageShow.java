package com.example.thitbvsinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.item.ItemSlideSale;

import java.util.List;

public class AdapterImageShow extends RecyclerView.Adapter<AdapterImageShow.NewHolder> {
    private List<ItemSlideSale>slideSales;
    private Context context;

    public AdapterImageShow(List<ItemSlideSale> slideSales, Context context) {
        this.slideSales = slideSales;
        this.context = context;
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.item_sale,parent,false);
        return new NewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
        holder.imageView.setImageResource(slideSales.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return slideSales.size();
    }

    public static class NewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public NewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.img_slide);
        }
    }
}
