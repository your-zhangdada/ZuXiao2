package com.zuxiao2.zuxiao2.ui.fragment.mine.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.bean.BankListBean;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.PutforwardActivity;

import java.util.List;
    //获取银行卡列表
public class RecyclerBank extends RecyclerView.Adapter<RecyclerBank.ViewHolder> {
    Context context;
    List<BankListBean.DataBean> data;
    public RecyclerBank( Context context, List<BankListBean.DataBean> data) {
        this.context =context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.banklist_item,null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String cardNumber = data.get(i).getCardNumber();
        String str = cardNumber.substring(cardNumber.length()-4,cardNumber.length());
        TextPaint paint = viewHolder.tv_shuzi.getPaint();
        paint.setFakeBoldText(true);
        viewHolder.tv_shuzi.setText("**** **** **** *** "+str);
        viewHolder.im_bank_head.setImageResource(R.mipmap.zhongguoyinlian1);
        viewHolder.im_bank.setImageResource(R.mipmap.zhongguoyinlian);
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PutforwardActivity.class);
                String cardNumber1 = data.get(i).getCardNumber();
                intent.putExtra("cardNumber1",cardNumber1);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im_bank_head,im_bank;
        TextView tv_shuzi;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            tv_shuzi = itemView.findViewById(R.id.tv_shuzi);
            im_bank_head = itemView.findViewById(R.id.im_bank_head);
            im_bank = itemView.findViewById(R.id.im_bank);
        }
    }
}
