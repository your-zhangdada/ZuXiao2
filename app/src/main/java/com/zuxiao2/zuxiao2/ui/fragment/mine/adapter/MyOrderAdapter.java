package com.zuxiao2.zuxiao2.ui.fragment.mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;
import com.zuxiao2.zuxiao2.ui.myorder.LianXiKeFuActivity;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {
    //全部订单适配器
    Context context;
    List<MyOrederBean.DataBean.ListBean> list;

    public MyOrderAdapter(Context context, List<MyOrederBean.DataBean.ListBean> list) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //item  条目布局
        View inflate = LayoutInflater.from(context).inflate(R.layout.myeq_inthelease, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List<MyOrederBean.DataBean.ListBean.ItemsBean> items = list.get(i).getItems();
        viewHolder.zhuangtai.setText(list.get(i).getStateName());
        Glide.with(context).load(items.get(0).getProductPic()).into(viewHolder.orderphoto);
        viewHolder.ordername.setText(items.get(0).getProductName());
        viewHolder.guige.setText(items.get(0).getSkuAttributes()+" * "+items.get(0).getNum()+"台");
        viewHolder.ordertime.setText(list.get(i).getDay()+"天");
        viewHolder.yajin.setText(items.get(0).getPledge()+"元");
        viewHolder.allmoney.setText("总价 : "+list.get(i).getAllMoney());
        String stateName = list.get(i).getStateName();
        if (stateName.equals("交易关闭")){
            viewHolder.kefu.setVisibility(View.INVISIBLE);
            viewHolder.closeorder.setVisibility(View.INVISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.topay.setText("取消订单");
        }
        if (stateName.equals("待付款")){
            viewHolder.kefu.setVisibility(View.VISIBLE);
            viewHolder.closeorder.setVisibility(View.VISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.kefu.setText("联系客服");
            viewHolder.closeorder.setText("取消订单");
            viewHolder.topay.setText("立即付款");
        }
        if (stateName.equals("待发货")){
            viewHolder.kefu.setVisibility(View.INVISIBLE);
            viewHolder.closeorder.setVisibility(View.INVISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.topay.setText("提醒发货");
        }
        if (stateName.equals("待收货")){
            viewHolder.kefu.setVisibility(View.INVISIBLE);
            viewHolder.closeorder.setVisibility(View.VISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.topay.setText("确认收货");
            viewHolder.closeorder.setText("查看物流");
        }
        if (stateName.equals("退款中")|| stateName.equals("退款成功")){
            viewHolder.kefu.setVisibility(View.INVISIBLE);
            viewHolder.closeorder.setVisibility(View.INVISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.topay.setText("查看详情");
        }
        if (stateName.equals("已完成")){
            viewHolder.kefu.setVisibility(View.INVISIBLE);
            viewHolder.closeorder.setVisibility(View.INVISIBLE);
            viewHolder.topay.setVisibility(View.VISIBLE);
            viewHolder.topay.setText("租赁中");
        }
        viewHolder.kefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,LianXiKeFuActivity.class);
                context.startActivity(intent);
            }
        });

        setCloseOrder.setonListener(viewHolder.closeorder,i);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView zhuangtai;
        private final ImageView orderphoto;
        private final TextView ordername;
        private final TextView guige;
        private final TextView ordertime;
        private final TextView yajin;
        private final TextView allmoney;
        private final TextView kefu;
        private final TextView closeorder;
        private final TextView topay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            zhuangtai = itemView.findViewById(R.id.myorder_recy_item_type);
            orderphoto = itemView.findViewById(R.id.myorder_recy_item_orderphoto);
            ordername = itemView.findViewById(R.id.myorder_recy_item_ordername);
            guige = itemView.findViewById(R.id.myorder_recy_item_guige);
            ordertime = itemView.findViewById(R.id.myorder_recy_item_ordertime);
            yajin = itemView.findViewById(R.id.myorder_recy_item_yajin);
            allmoney = itemView.findViewById(R.id.myorder_recy_item_allmoney);
            kefu = itemView.findViewById(R.id.lixikefu);
            closeorder = itemView.findViewById(R.id.closeorder);
            topay = itemView.findViewById(R.id.topay);
        }
    }


    public interface setCloseOrder{
        void setonListener(TextView close,int position);
    }

    private setCloseOrder setCloseOrder;

    public void getCloseOrder(setCloseOrder setCloseOrder){
        this.setCloseOrder =setCloseOrder;
    }
}
