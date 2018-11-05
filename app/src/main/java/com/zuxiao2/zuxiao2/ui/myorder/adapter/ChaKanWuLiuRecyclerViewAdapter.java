package com.zuxiao2.zuxiao2.ui.myorder.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.ChaKanWuLiuBean;
import com.zuxiao2.zuxiao2.ui.myorder.ChaKanWuliuActivity;
import com.zuxiao2.zuxiao2.utils.DensityUtil;

import java.util.ArrayList;

public class ChaKanWuLiuRecyclerViewAdapter extends RecyclerView.Adapter<ChaKanWuLiuRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private  ArrayList<ChaKanWuLiuBean> list;

    public ChaKanWuLiuRecyclerViewAdapter(Context context, ArrayList<ChaKanWuLiuBean> list) {

        this.context =context;
        this.list =list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chakanwuliu_recyclerview_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        try {
            viewHolder.tv_status.setText(list.get(i).getContext());//订单状态
            viewHolder.tv_time.setText(list.get(i).getTime());//时间

            if (i == 0) {
                //红色的圆点
                viewHolder.iv_status.setImageResource(R.drawable.logistics_shape_circle_red);
                RelativeLayout.LayoutParams pointParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(context, 20), DensityUtil.dp2px(context, 20));
                pointParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                viewHolder.iv_status.setLayoutParams(pointParams);

                viewHolder.tv_time.setTextColor(context.getResources().getColor(R.color.bg_regist_bg));
                viewHolder.tv_status.setTextColor(context.getResources().getColor(R.color.bg_regist_bg));

                //灰色的竖线
                RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(context, 1), ViewGroup.LayoutParams.MATCH_PARENT);
                lineParams.addRule(RelativeLayout.BELOW, R.id.iv_status);//让直线置于圆点下面
                lineParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                viewHolder.iv_line.setLayoutParams(lineParams);

            } else {
//                holder.iv_status.setBackgroundResource(R.mipmap.ic_logistics_bottom);
                viewHolder.iv_status.setImageResource(R.drawable.shape_circle_logistics_gray);
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(DensityUtil.dp2px(context, 10), DensityUtil.dp2px(context, 10));
                lp.addRule(RelativeLayout.CENTER_IN_PARENT);

                viewHolder.iv_status.setLayoutParams(lp);

                viewHolder.tv_time.setTextColor(context.getResources().getColor(R.color.hui));
                viewHolder.tv_status.setTextColor(context.getResources().getColor(R.color.hui));

                //灰色的竖线
                RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(context, 1), ViewGroup.LayoutParams.MATCH_PARENT);
//                lineParams.addRule(RelativeLayout.BELOW, R.id.iv_status);//让直线置于圆点下面
                lineParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                viewHolder.iv_line.setLayoutParams(lineParams);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_status;
        TextView tv_status;
        TextView tv_time;
        ImageView iv_line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_line = (ImageView) itemView.findViewById(R.id.iv_line);
            iv_status = (ImageView) itemView.findViewById(R.id.iv_status);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
