package com.example.thitbvsinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.item.Product;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.MyHolder> {
    private List<Product>products;
    private Context context;

    public AdapterList(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.item_product,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvName.setText(products.get(position).getName());
        holder.tvPrice.setText(products.get(position).getPrize());
        holder.bitmap.setImageResource(products.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvPrice;
        private ImageView bitmap;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name_product);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_price);
            bitmap = (ImageView)itemView.findViewById(R.id.img_bitmap);
        }
    }
}
