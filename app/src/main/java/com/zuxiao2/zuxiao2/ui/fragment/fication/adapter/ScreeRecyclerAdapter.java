package com.zuxiao2.zuxiao2.ui.fragment.fication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.Second;

import java.util.List;

public class ScreeRecyclerAdapter extends RecyclerView.Adapter<ScreeRecyclerAdapter.Holder> {
    Context context;
    List<Second.DataBean.ItemsBean.SpecificationBean> itemsBean;
    public ScreeRecyclerAdapter(Context context, List<Second.DataBean.ItemsBean.SpecificationBean> itemsBean) {
        this.context = context;
        this.itemsBean = itemsBean;
    }

    @NonNull
    @Override
    public ScreeRecyclerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.finc_item, null, false);

        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ScreeRecyclerAdapter.Holder holder, int i) {
            holder.tv_jx_iphoneX.setText(itemsBean.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return itemsBean.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
       ImageView im_iphones;
       TextView tv_jx_iphoneX,tv_myj,tv_set,tv_bg_iphone,tv_yuezu,tv_shopin;
        public Holder(@NonNull View itemView) {
            super(itemView);
            im_iphones =  itemView.findViewById(R.id.im_iphones);
            tv_jx_iphoneX =  itemView.findViewById(R.id.tv_jx_iphoneX);
            tv_myj =  itemView.findViewById(R.id.tv_myj);
            tv_set =  itemView.findViewById(R.id.tv_set);
            tv_bg_iphone =  itemView.findViewById(R.id.tv_bg_iphone);
            tv_yuezu =  itemView.findViewById(R.id.tv_yuezu);
            tv_shopin =  itemView.findViewById(R.id.tv_shopin);
        }
    }
}
