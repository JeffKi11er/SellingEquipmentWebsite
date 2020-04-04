package com.example.thitbvsinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.adapter.AdapterList;
import com.example.thitbvsinh.adapter.AdapterNewProduct;
import com.example.thitbvsinh.item.Product;

import java.util.ArrayList;
import java.util.List;

public class FragmentNewProduct extends Fragment {
    private List<Product>products;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_product_fragment,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        products = new ArrayList<>();
        products.add(new Product(R.drawable.wcnam,"Bồn tiểu nam treo tường American VF-6401","1,900,000 đ"));
        products.add(new Product(R.drawable.chaurua,"Chậu rửa mặt lavabo TOTO LT515","3,285,000 đ"));
        products.add(new Product(R.drawable.voihoasen,"Vòi hoa sen tắm nóng lạnh INAX BFV-1403S-4C",
                "1,830,000 đ"));
        products.add(new Product(R.drawable.bonxi,"Bồn cầu TOTO CS767T3","6,399,000 đ"));
        AdapterNewProduct adapterList = new AdapterNewProduct(products,getContext());
        RecyclerView rc1 = (RecyclerView) getActivity().findViewById(R.id.rcl_new);
        rc1.setLayoutManager(new GridLayoutManager(getContext(),5));
        rc1.setAdapter(adapterList);
    }
}
