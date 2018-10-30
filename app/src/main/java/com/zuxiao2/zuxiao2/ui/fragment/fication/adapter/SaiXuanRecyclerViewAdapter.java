package com.zuxiao2.zuxiao2.ui.fragment.fication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.Second;

import java.util.ArrayList;
import java.util.List;

public class SaiXuanRecyclerViewAdapter extends RecyclerView.Adapter<SaiXuanRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Second.DataBean.ItemsBean.SpecificationBean> spec;
    public SaiXuanRecyclerViewAdapter(Context context, ArrayList<Second.DataBean.ItemsBean.SpecificationBean> spec) {

        this.context =context;
        this.spec =spec;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.saixuan_recyclerview_adapter_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        viewHolder.title.setText(spec.get(i).getName());
        final List<Second.DataBean.ItemsBean.SpecificationBean.ValuesBean> values = spec.get(i).getValues();
        SaiXuanRecyclerViewItemRecyAdapter saiXuanRecyclerViewItemRecyAdapter = new SaiXuanRecyclerViewItemRecyAdapter(context,values);
        viewHolder.recyclerView.setAdapter(saiXuanRecyclerViewItemRecyAdapter);
        viewHolder.name.setText("全部");
        saiXuanRecyclerViewItemRecyAdapter.getPinPaiData(new SaiXuanRecyclerViewItemRecyAdapter.setPinPaiData() {
            @Override
            public void setPinPaiItemData(View view, int position) {
                viewHolder.name.setText(values.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return spec.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private RecyclerView recyclerView;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.saixuan_item_name);
            recyclerView = itemView.findViewById(R.id.saixuan_item_recycler);
            title = itemView.findViewById(R.id.saixuan_item_title);
        }
    }
}
