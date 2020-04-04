package com.example.tntn;

import android.net.Uri;
import android.os.AsyncTask;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLAsync extends AsyncTask<String, Void, ArrayList<News>> {
    private ParserXMLCallBack callBack;

    public XMLAsync(ParserXMLCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        String api = "https://news.google.de/news/feeds?pz=1&cf=vi_vn&ned=vi_vn&hl=vi_vn&q=";
        String keySearch = strings[0];
        keySearch = Uri.encode(keySearch);
        api = api + keySearch;
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLParsers xmlParsers = new XMLParsers();
            parser.parse(api,xmlParsers);
            return xmlParsers.getArr();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<News> arrayList) {
        super.onPostExecute(arrayList);
        callBack.onParserFinish(arrayList);
    }

    public interface ParserXMLCallBack{
        void onParserFinish(ArrayList<News>arrayList);
    }
}
