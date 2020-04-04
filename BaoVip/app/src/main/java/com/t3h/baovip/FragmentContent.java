package com.t3h.baovip;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GiangVien T3H on 12/27/2019.
 */

public class FragmentContent extends Fragment {
    private RecyclerView rc;
    private NewsAdapter adapter;
    private List<ItemDataNew> itemDataNews;
    private String link;

    public void setLink(String link) {
        this.link = link;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_content,
                container,
                false
        );
        rc = view.findViewById(R.id.rc);
        adapter = new NewsAdapter(itemDataNews);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setAdapter(adapter);
        if(link.equals("https://www.24h.com.vn")){
            crawlData();
        }else {
            crawlSinglePage();
        }

        return view;
    }

    private void crawlData(){
        itemDataNews = new ArrayList<>();
        new AsyncTask<String, Void, Void>(){
            @Override
            protected Void doInBackground(String... values) {

                try {
                    Document doc = Jsoup.connect(values[0]).get();
                    Elements els = doc.select("div.bxDoC");
                    for (Element el : els) {

                        String title = el.select("a").first().text();
                        String linkImage = el.select("img").attr("data-original");
                        String content =el.select("span.nwsSpSpc").text();
                        String linkDetail =  el.select("a").attr("href");
                        Log.d("Content", "title: " + title);
                        Log.d("Content", "content: " + content);
                        Log.d("Content", "linkImage: " + linkImage);
                        Log.d("Content", "linkDetail: " + linkDetail);
                        Log.d("Content", "=============================");
                        itemDataNews.add(
                                new ItemDataNew(
                                        title, content, linkImage,
                                        linkDetail
                                )
                        );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.setDatas(itemDataNews);
                adapter.notifyDataSetChanged();
            }
        }.execute(link);

    }
    private void crawlSinglePage(){
        itemDataNews = new ArrayList<>();
        new AsyncTask<String, Void, Void>(){
            @Override
            protected Void doInBackground(String... values) {

                try {
                    Document doc = Jsoup.connect(values[0]).get();
                    Elements els = doc.select("article.bxDoiSbIt");
                    for (Element el : els) {

                        String title = el.select("a").attr("title");
                        String linkImage = el.select("img").attr("data-original");
                        String content =el.select("span.nwsSp").text();
                        String linkDetail =  el.select("a").attr("href");
                        Log.d("Content", "title: " + title);
                        Log.d("Content", "content: " + content);
                        Log.d("Content", "linkImage: " + linkImage);
                        Log.d("Content", "linkDetail: " + linkDetail);
                        Log.d("Content", "=============================");
                        itemDataNews.add(
                                new ItemDataNew(
                                        title, content, linkImage,
                                        linkDetail
                                )
                        );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.setDatas(itemDataNews);
                adapter.notifyDataSetChanged();
            }
        }.execute(link);

    }
}
