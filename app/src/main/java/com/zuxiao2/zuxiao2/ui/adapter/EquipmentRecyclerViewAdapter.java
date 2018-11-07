package com.zuxiao2.zuxiao2.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.CommodityBean;
import com.zuxiao2.zuxiao2.ui.activity.Activity_AddDZ;

import java.util.List;

public class EquipmentRecyclerViewAdapter extends RecyclerView.Adapter<EquipmentRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<CommodityBean.DataBean.InsuranceListBean> insuranceList;
    public EquipmentRecyclerViewAdapter(Context context, List<CommodityBean.DataBean.InsuranceListBean> insuranceList) {
        this.context =context;
        this.insuranceList =insuranceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.equipmentrecyclerviewadapter_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(insuranceList.get(i).getName()+": ￥"+insuranceList.get(i).getMoney());
    }

    @Override
    public int getItemCount() {
        return insuranceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private CheckBox cb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.equipment_baoxian_recy_item_tv);
            cb = itemView.findViewById(R.id.equipment_baoxian_recy_item_cb);
        }
    }
}
