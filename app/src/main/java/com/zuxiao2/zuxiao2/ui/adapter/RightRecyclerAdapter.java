package com.zuxiao2.zuxiao2.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.Second;

import java.util.List;
//分类  二级列表   RecyclerView   adapter

public class RightRecyclerAdapter extends RecyclerView.Adapter<RightRecyclerAdapter.MViewHorder> implements View.OnClickListener {
    private final Context context;
    private final List<Second.DataBean.ItemsBean> list;


//使外界可以set

    private onclicklinster onclicklinster;

    public RightRecyclerAdapter(Context context, List<Second.DataBean.ItemsBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnclicklinster(RightRecyclerAdapter.onclicklinster onclicklinster) {
        this.onclicklinster = onclicklinster;
    }


    //这个方法来生成holder对象;
    @Override
    public MViewHorder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itmview = LayoutInflater.from(context).inflate(R.layout.item_fenei, parent,false);
        return new MViewHorder(itmview);
    }
    //这个方法来绑定数据到holder;
    @Override
    public void onBindViewHolder(MViewHorder holder, final int position) {
           holder.tv_item_text.setText(list.get(position).getName());
            //不能忘了
        holder.tv_item_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //点击事件
                onclicklinster.onItemClick(position);
//                Intent intent = new Intent(context, FincActivity.class);
//                Second.DataBean.ItemsBean itemsBean = list.get(position);
//                intent.putExtra("itemsBean",itemsBean);
//                context.startActivity(intent);
            }
        });

    }

    //返回数据集合的数量
    @Override
    public int getItemCount() {
        return list.size();
    }


    class MViewHorder extends RecyclerView.ViewHolder {

        private TextView tv_item_text;

        public MViewHorder(View itemView) {
            super(itemView);
            tv_item_text = (TextView) itemView.findViewById(R.id.tv_item_text);
        }
    }
    /**
     * 1--->声明一个接口;
     * 2-->写实现类,
     * 3-->调用
     */
    public interface onclicklinster {
        public void onItemClick(int ppp);
    }

    @Override
    public void onClick(View v) {
        if (null != onclicklinster) {
            Integer per = (Integer) v.getTag();
            onclicklinster.onItemClick(per);
        }
    }
}

