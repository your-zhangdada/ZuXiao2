package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.HomeBean;
import com.zuxiao2.zuxiao2.contract.AddBankContract;
import com.zuxiao2.zuxiao2.presenter.AddBankPrerenter;

import java.util.HashMap;
import java.util.Map;

/**
 *   TODO 添加银行卡
 */
public class AddBankActivity extends BaseActivity<AddBankPrerenter> implements AddBankContract.View,View.OnClickListener {
    private Button btn_xiayibu;
    @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_add_bank;
    }
    @Override
    protected void initView() {
        //绑定银行卡
        btn_xiayibu = findViewById(R.id.btn_xiayibu);
        btn_xiayibu.setOnClickListener(this);

    }
    @Override
    protected void initData() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_xiayibu:
                //请求
                Map<String,String> map = new HashMap<>();
                presenter.getAddBanks(map);
            startActivity(new Intent(this,AddTypeActivity.class));
                break;
        }
    }

    @Override
    public void showAddBank(HomeBean homeBean) {

    }
}
