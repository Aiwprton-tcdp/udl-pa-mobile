package com.aiwprton.udl_pa_mobile.ui.deals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aiwprton.udl_pa_mobile.R;
import com.aiwprton.udl_pa_mobile.models.Deal;

import java.util.ArrayList;

public class DealsListAdapter extends ArrayAdapter<Deal> {
    static class DealHolder {
        ListView Name;
    }

    private static ArrayList<Deal> dealsList;
    private LayoutInflater mInflater;


    public DealsListAdapter(Context dealsFragment, ArrayList<Deal> data) {
//        super(dealsFragment, -1, data);
        super(dealsFragment, android.R.layout.simple_list_item_1, data);
        dealsList = data;
        mInflater = LayoutInflater.from(dealsFragment);
    }


    @Override
    public int getCount() {
        return dealsList.size();
    }

    @Override
    public Deal getItem(int arg0) {
        return dealsList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) {
        DealHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fragment_deals, null);
            holder = new DealHolder();
            holder.Name = convertView.findViewById(android.R.id.list);

            convertView.setTag(holder);
        } else {
            holder = (DealHolder) convertView.getTag();
        }

        Deal dm = getItem(position);
        String s = String.format("№ %s (%s)", dm.ID, dm.BEGINDATE);
        holder.Name.setTag(s);//.setText(dealsList.get(position).Name);

        return convertView;
    }
}
