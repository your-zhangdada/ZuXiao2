package com.zuxiao2.zuxiao2.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.Home_FL;
import com.zuxiao2.zuxiao2.ui.hometabftagment.classbase.CommodityActiivity;

import java.util.List;

public class Onedollar_adapter extends Adapter<RecyclerView.ViewHolder> {
    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;
    Context context;
    List<Home_FL.DataBean.ListBean> list;
    public Onedollar_adapter(Context context, List<Home_FL.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view;
        if (ONE_ITEM==viewType){
            view = LayoutInflater.from(context).inflate(R.layout.homr_commodity_fragment_one, parent, false);
            holder = new MyViewHolder(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.home_commodity_fragment_two, parent, false);
            holder = new TwoViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyViewHolder){
            Glide.with(context).load(list.get(position).getPic()).into(((MyViewHolder) holder).im_liebiao_zuo);
            ((MyViewHolder) holder).tv_tongyong_zuo.setText(list.get(position).getName());
            ((MyViewHolder) holder).tv_price_zuo.setText(list.get(position).getCanUseNums()+"/天");
            ((MyViewHolder) holder).tv_baoyou_zuo.setText(list.get(position).getSaleNum()+"");
            ((MyViewHolder) holder).tv_xiaoliang_zuo.setText(list.get(position).getDescribe());
            ((MyViewHolder) holder).tv_kucunz_zuo.setText(list.get(position).getTag());

            ((MyViewHolder)holder).im_liebiao_zuo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到商品详情页面
                    Intent intent = new Intent(context,CommodityActiivity.class);
                    int id = list.get(position).getId();
                    intent.putExtra("id",id+"");
                    context.startActivity(intent);
                }
            });
        }else {
            Glide.with(context).load(list.get(position).getPic()).into(((TwoViewHolder) holder).im_liebiao_you);
            ((TwoViewHolder) holder).tv_tongyong_you.setText(list.get(position).getName());
            ((TwoViewHolder) holder).tv_price_two.setText(list.get(position).getCanUseNums()+"/天");
            ((TwoViewHolder) holder).tv_baoyou_you.setText(list.get(position).getSaleNum()+"");
            ((TwoViewHolder) holder).tv_xiaoliang_you.setText(list.get(position).getDescribe());
            ((TwoViewHolder) holder).tv_kucun_you.setText(list.get(position).getTag());

            ((TwoViewHolder) holder).im_liebiao_you.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到商品详情页面
                    Intent intent = new Intent(context,CommodityActiivity.class);
                    int id = list.get(position).getId();
                    intent.putExtra("id",id+"");
                    context.startActivity(intent);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView im_liebiao_zuo;
        TextView tv_tongyong_zuo,tv_price_zuo,tv_baoyou_zuo,tv_xiaoliang_zuo,tv_kucunz_zuo;
        public MyViewHolder(View itemView) {
            super(itemView);
            im_liebiao_zuo = itemView.findViewById(R.id.im_liebiao_zuo);
            tv_tongyong_zuo = itemView.findViewById(R.id.tv_tongyong_zuo);
            tv_price_zuo = itemView.findViewById(R.id.tv_price_zuo);
            tv_baoyou_zuo = itemView.findViewById(R.id.tv_baoyou_zuo);
            tv_xiaoliang_zuo = itemView.findViewById(R.id.tv_xiaoliang_zuo);
            tv_kucunz_zuo = itemView.findViewById(R.id.tv_kucunz_zuo);

        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{
        ImageView im_liebiao_you;
         TextView tv_tongyong_you,tv_price_two,tv_baoyou_you,tv_xiaoliang_you,tv_kucun_you;
        public TwoViewHolder(View itemView) {
            super(itemView);
            im_liebiao_you = itemView.findViewById(R.id.im_liebiao_you);
            tv_tongyong_you = itemView.findViewById(R.id.tv_tongyong_you);
            tv_price_two = itemView.findViewById(R.id.tv_price_two);
            tv_baoyou_you = itemView.findViewById(R.id.tv_baoyou_you);
            tv_xiaoliang_you = itemView.findViewById(R.id.tv_xiaoliang_you);
            tv_kucun_you = itemView.findViewById(R.id.tv_kucun_you);
        }
    }



    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ONE_ITEM;
        }else{
            return TWO_ITEM;
        }
    }

    //第一个点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    private OnItemClickListener onItemClickListener;

    /** * 自定义监听回调，RecyclerView 的 单击和长按事件 */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    //第二个点击事件
    public void setOnItemClickListenerTwo(OnItemClickListenerTwo onItemClickListenerTwo){
        this.onItemClickListenerTwo = onItemClickListenerTwo;
    }
    private OnItemClickListenerTwo onItemClickListenerTwo;
    public interface OnItemClickListenerTwo {
        void onItemClicktwo(int position);
    }
}
