package com.aysenurtoprak.connecttodoctor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aysenur toprak on 30/07/2018.
 */

public class BolumAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<Bolum> mbolumlistesi;

    public BolumAdapter(Activity activity, ArrayList<Bolum> bolums) {

        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mbolumlistesi = bolums;
    }
    @Override
    public int getCount() {
        return mbolumlistesi.size();
    }

    @Override
    public Object getItem(int position) {
        return mbolumlistesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satirView;
        satirView = mInflater.inflate(R.layout.bolum_satir, viewGroup, false);
        TextView txtbolum = (TextView) satirView.findViewById(R.id.txtbolumsatir);
        final Bolum bolum=mbolumlistesi.get(i);
        txtbolum.setText(bolum.getBolumAdi());
        return satirView;

    }
}
