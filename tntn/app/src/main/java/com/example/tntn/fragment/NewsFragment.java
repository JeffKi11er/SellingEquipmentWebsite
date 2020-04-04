package com.example.tntn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;

import com.example.tntn.News;
import com.example.tntn.R;
import com.example.tntn.XMLAsync;
import com.example.tntn.XMLParsers;
import com.example.tntn.adapter.NewsAdapter;

import java.util.ArrayList;

public class NewsFragment extends BaseFragment implements XMLAsync.ParserXMLCallBack, View.OnClickListener {
    private RecyclerView lvNews;
    private NewsAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_fragment_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvNews = findViewById(R.id.lv_news);
        adapter = new NewsAdapter(getContext());
        lvNews.setAdapter(getParent().getNewsAdapter());

    }

    @Override
    public String getTitle() {
        return "News";
    }


    @Override
    public void onParserFinish(ArrayList<News> arrayList) {

    }

    @Override
    public void onClick(View v) {

    }
}
