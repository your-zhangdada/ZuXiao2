package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class MyWalletActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout im_back;
    private TextView tv_yue;
    private Button btn_tixian;
    private TextView tv_zuoritixian;
    private TextView tv_mianya;
    private TextView tv_tiaozheng;
    private LinearLayout my_bank_card;
    private LinearLayout my_account_record;
    private LinearLayout my_present_record;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_my_wallet;
    }

    @Override
    protected void initView() {
        //返回
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
        //我的余额
        tv_yue = findViewById(R.id.tv_yue);
        //提现
        btn_tixian = findViewById(R.id.btn_tixian);
        btn_tixian.setOnClickListener(this);
        //昨日提现金额
        tv_zuoritixian = findViewById(R.id.tv_zuoritixian);
        //免押额度
        tv_mianya = findViewById(R.id.tv_mianya);
        //调整额度
        tv_tiaozheng = findViewById(R.id.tv_tiaozheng);
        tv_tiaozheng.setOnClickListener(this);
        //我的银行卡
        my_bank_card = findViewById(R.id.my_bank_card);
        my_bank_card.setOnClickListener(this);
        //到账记录
        my_account_record = findViewById(R.id.my_account_record);
        my_account_record.setOnClickListener(this);
        //我的银行卡
        my_present_record = findViewById(R.id.my_present_record);
        my_present_record.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_back:
                finish();
                break;
            case R.id.btn_tixian:
                //提现
                break;
            case R.id.tv_tiaozheng:
                //调整额度
                break;
            case R.id.my_bank_card:
                //我的银行卡  添加 卡
               startActivity(new Intent(this,MyBankCardActivity.class));

                break;
            case R.id.my_account_record:
                //到账记录
                break;
            case R.id.my_present_record:
                //我的银行卡
                break;
        }
    }
}
