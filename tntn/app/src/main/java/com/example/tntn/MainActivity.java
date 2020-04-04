package com.example.tntn;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.example.tntn.adapter.NewsAdapter;
import com.example.tntn.adapter.PageAdapter;
import com.example.tntn.fragment.FavorFragment;
import com.example.tntn.fragment.NewsFragment;
import com.example.tntn.fragment.SavedFragment;
import com.example.tntn.utils.DialogUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, SearchView.OnQueryTextListener, XMLAsync.ParserXMLCallBack {
    private NewsFragment fragmentNews = new NewsFragment();
    private SavedFragment fragmentSaved = new SavedFragment();
    private FavorFragment fragmentFavor = new FavorFragment();
    private ViewPager viewPager;
    private PageAdapter adapter;
    private NewsAdapter newsAdapter;
    private TabLayout tabTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        newsAdapter = new NewsAdapter(this);
        viewPager = findViewById(R.id.paper);
        adapter = new PageAdapter(getSupportFragmentManager(),
                fragmentNews,fragmentSaved,fragmentFavor);
        viewPager.setAdapter(adapter);
        tabTitle = findViewById(R.id.tab_title);
        tabTitle.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView = (SearchView) menu.
                findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    public NewsFragment getFragmentNews() {
        return fragmentNews;
    }

    public SavedFragment getFragmentSaved() {
        return fragmentSaved;
    }

    public FavorFragment getFragmentFavor() {
        return fragmentFavor;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Log.e(getClass().getName(), "onPageSelected- " + i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else {
            viewPager.setCurrentItem(0);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (query.isEmpty()){
        return false;
        }
        DialogUtils.show(this);
        XMLAsync async = new XMLAsync(this);
        async.execute(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public NewsAdapter getNewsAdapter() {
        return newsAdapter;
    }

    @Override
    public void onParserFinish(ArrayList<News> arrayList) {
        DialogUtils.dissmiss();
        newsAdapter.setData(arrayList);
    }
}
