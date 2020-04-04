package com.example.thitbvsinh.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.thitbvsinh.item.Product;

import java.util.List;

public class AdapterSaleProduct extends AdapterList {
    public AdapterSaleProduct(List<Product> products, Context context) {
        super(products, context);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }
}
