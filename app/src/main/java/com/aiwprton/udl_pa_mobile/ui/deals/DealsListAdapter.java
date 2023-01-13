package com.aiwprton.udl_pa_mobile.ui.deals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aiwprton.udl_pa_mobile.R;
import com.aiwprton.udl_pa_mobile.models.Deal;

import java.util.ArrayList;

public class DealsListAdapter extends RecyclerView.Adapter<DealsListAdapter.ViewHolder> {
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


    private static ArrayList<Deal> dealsList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    public DealsListAdapter(Context dealsFragment, ArrayList<Deal> data) {
        dealsList = data;
        mInflater = LayoutInflater.from(dealsFragment);
    }


    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fragment_deals_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Deal deal = dealsList.get(position);
        String s = String.format("№ %s (%s)", deal.ID, deal.BEGINDATE);
        holder.Data.setText(s);
    }

    @Override
    public int getItemCount() {
        return dealsList.size();
    }

    public Deal getItem(int arg0) {
        return dealsList.get(arg0);
    }
    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Data;

        ViewHolder(View itemView) {
            super(itemView);
            Data = itemView.findViewById(R.id.deal_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAbsoluteAdapterPosition());
        }
    }
}
