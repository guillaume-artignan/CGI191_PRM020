package com.example.cgi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.cgi.R;
import com.example.cgi.model.Plat;

import java.util.zip.Inflater;

public class PlatAdapter extends ArrayAdapter<Plat> {


    public PlatAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //super.getView(position, convertView, parent);
        Plat p = this.getItem(position);

        LayoutInflater lin = LayoutInflater.from(this.getContext());
        View v = lin.inflate(R.layout.plat,null);

        return v;

    }
}
