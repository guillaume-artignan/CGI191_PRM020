package com.example.cgi;

import com.example.cgi.model.Avis;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utils {

    public static <T> T get(String url, Class<T> c) throws IOException {
        URL u = new URL(url);
        URLConnection http = u.openConnection();
        InputStream ins = http.getInputStream();
        Gson gson = new Gson();
        return gson.fromJson(new InputStreamReader(ins),c);
    }

    public static Avis[] getAvis(String url) throws IOException {
        URL u = new URL(url);
        URLConnection http = u.openConnection();
        InputStream ins = http.getInputStream();
        Gson gson = new Gson();
        return gson.fromJson(new InputStreamReader(ins),Avis[].class);
    }
}
