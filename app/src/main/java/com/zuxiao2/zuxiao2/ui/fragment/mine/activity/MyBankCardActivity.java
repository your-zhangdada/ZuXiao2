package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.BankListBean;
import com.zuxiao2.zuxiao2.contract.BankListConteact;
import com.zuxiao2.zuxiao2.presenter.BankListPrenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.RecyclerBank;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//我的银行卡
public class MyBankCardActivity extends BaseActivity<BankListPrenter> implements BankListConteact.View,View.OnClickListener {

    private TextView tv_addbank;
    private List<BankListBean.DataBean> datas = new ArrayList<>();
    private RecyclerView recyclerBank;
    private RecyclerBank recyclerBanks;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_my_bank_card;
    }

    @Override
    protected void initView() {
        //添加银行卡
        tv_addbank = findViewById(R.id.tv_addbank);
        tv_addbank.setOnClickListener(this);
        recyclerBank = findViewById(R.id.recyclerBank);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        recyclerBank.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        presenter.getBankList(header);
        recyclerBanks = new RecyclerBank(this, datas);
        recyclerBank.setAdapter(recyclerBanks);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_addbank:
                //添加银行卡
            startActivity(new Intent(this,AddTypeActivity.class));
                break;
        }
    }

    @Override
    public void showBankList(BankListBean bankListBean) {
        if (bankListBean.getMsg().equals("ok")) {
            List<BankListBean.DataBean> data = bankListBean.getData();
            datas.clear();
            datas.addAll(data);
            recyclerBanks.notifyDataSetChanged();
        }else {
            Toast.makeText(this,"暂无数据！", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        presenter.getBankList(header);
    }
}
