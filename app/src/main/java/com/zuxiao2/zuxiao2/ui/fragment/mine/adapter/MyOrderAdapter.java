package com.zuxiao2.zuxiao2.ui.fragment.mine.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {
    //全部订单适配器
 //   Content content;
 @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //item  条目布局
     //   View inflate = LayoutInflater.from(content).inflate(R.layout.myeq_inthelease, null, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
     TextView tv_finish,tv_product_name,tv_product_info_tv,tv_lease_time,tv_lease_mons_tv,tv_je,tv_lj_zf;
     ImageView im;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
