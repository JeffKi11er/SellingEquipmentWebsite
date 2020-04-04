package com.example.thitbvsinh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thitbvsinh.R;
import com.example.thitbvsinh.adapter.AdapterImageShow;
import com.example.thitbvsinh.item.ItemSlideSale;

import java.util.ArrayList;
import java.util.List;

public class FragmetSale extends Fragment {
    private List<ItemSlideSale>slideSales;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sale,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        slideSales = new ArrayList<>();
        slideSales.add(new ItemSlideSale(R.drawable.boncau));
        slideSales.add(new ItemSlideSale(R.drawable.ruabat));
        slideSales.add(new ItemSlideSale(R.drawable.combothietke));
        slideSales.add(new ItemSlideSale(R.drawable.mayhutmui));
        slideSales.add(new ItemSlideSale(R.drawable.americankm));
        slideSales.add(new ItemSlideSale(R.drawable.densuoi));
        slideSales.add(new ItemSlideSale(R.drawable.gachinax));
        slideSales.add(new ItemSlideSale(R.drawable.beptuhutmui));
        slideSales.add(new ItemSlideSale(R.drawable.giamgia));
        AdapterImageShow imageShow = new AdapterImageShow(slideSales,getContext());
        RecyclerView recyclerView = (RecyclerView)getActivity().findViewById(R.id.rcl_sale_type);
        recyclerView.setAdapter(imageShow);
    }
}
