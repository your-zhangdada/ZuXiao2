package com.zuxiao2.zuxiao2.ui.fragment.fication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.FincBean;
import com.zuxiao2.zuxiao2.utils.GlideImageLoader;

import java.util.List;

public class ScreeRecyclerAdapter extends RecyclerView.Adapter<ScreeRecyclerAdapter.Holder> {
    Context context;
    List<FincBean.DataBean.ListBean> itemsBean;
    public ScreeRecyclerAdapter(Context context, List<FincBean.DataBean.ListBean> itemsBean) {
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
        Glide.with(context).load(itemsBean.get(i).getPic()).into(holder.im_iphones);
        holder.tv_jx_iphoneX.setText(itemsBean.get(i).getName());
        holder.tv_myj.setText(itemsBean.get(i).getTag());
        holder.tv_yuezu.setText("日租金： "+itemsBean.get(i).getShowPrice());
    }

    @Override
    public int getItemCount() {
        return itemsBean.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
       ImageView im_iphones;
       TextView tv_jx_iphoneX,tv_myj,tv_yuezu;
        public Holder(@NonNull View itemView) {
            super(itemView);
            im_iphones =  itemView.findViewById(R.id.im_iphones);
            tv_jx_iphoneX =  itemView.findViewById(R.id.tv_jx_iphoneX);
            tv_myj =  itemView.findViewById(R.id.tv_myj);
            tv_yuezu =  itemView.findViewById(R.id.tv_yuezu);
        }
    }

    public interface setOnClickData{

    }
}
