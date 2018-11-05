package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

//我的银行卡
public class MyBankCardActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_addbank;

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
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_addbank:
                //添加银行卡  做请求
            startActivity(new Intent(this,AddBankActivity.class));
                break;
        }
    }

}
