package com.zuxiao2.zuxiao2.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;
import com.zuxiao2.zuxiao2.ui.activity.Activity_SH_Dz;

import java.util.List;

public class ADD_RecylerAdapter extends RecyclerView.Adapter<ADD_RecylerAdapter.ViewHolder> {
    Context context;
    List<SHDZ_Bean.DataBean> data;
    public ADD_RecylerAdapter(Context context, List<SHDZ_Bean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_sh_dz, null, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv_name.setText(data.get(i).getLinkPerson());
        viewHolder.tv_phone.setText(data.get(i).getLinkPhone());
        viewHolder.tv_address.setText(data.get(i).getDetailAddress());
      /*  String s = viewHolder.tv_name.getText().toString();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(i);
        viewHolder.im_hand.setText(c);
        }*/

        viewHolder.tv_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击编辑

                Intent intent = new Intent(context, Activity_SH_Dz.class);
                SHDZ_Bean.DataBean dataBean = data.get(i);
                intent.putExtra("data",dataBean);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView im_hand,tv_name,tv_phone,tv_address,tv_bianji;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_hand = itemView.findViewById(R.id.im_hand);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_bianji = itemView.findViewById(R.id.tv_bianji);

        }
    }
}
