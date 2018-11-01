package com.zuxiao2.zuxiao2.ui.hometabftagment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.CommodityBean;

import java.util.ArrayList;

public class CommodityPopRecyclerAdapter extends RecyclerView.Adapter<CommodityPopRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private ArrayList<String> poplist;
    public CommodityPopRecyclerAdapter(Context context, ArrayList<String> poplist) {
        this.context =context;
        this.poplist =poplist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.commodity_pop_recycler_item, null, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.checkBox.setText(poplist.get(i));
    }

    @Override
    public int getItemCount() {
        return poplist.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.pop_recycler_item_checkbox);
        }
    }
}
