package com.zuxiao2.zuxiao2.ui.fragment.fication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.PinPaiBean;
import com.zuxiao2.zuxiao2.ui.fragment.fication.activity.FincActivity;

import java.util.List;

public class PinPaiRecyclerViewAdapter extends RecyclerView.Adapter<PinPaiRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private  List<PinPaiBean.DataBean> data;
    public PinPaiRecyclerViewAdapter(Context context, List<PinPaiBean.DataBean> data) {

        this.context =context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pinpai_recycler_adapter_item, null, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(data.get(i).getName());
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        if (v!=null){
            setData.setPinPaiItemData(v,(Integer) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pinpai_item_name);
        }
    }
    public interface setPinPaiData{
        void  setPinPaiItemData(View view,int  position);
    }

    public setPinPaiData setData;

    public void getPinPaiData(setPinPaiData setData){
        this.setData= setData;
    }
}
