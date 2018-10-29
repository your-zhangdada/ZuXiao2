package com.zuxiao2.zuxiao2.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;

public class Activity_SH_Dz extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_add_dz;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        SHDZ_Bean.DataBean data = (SHDZ_Bean.DataBean) intent.getSerializableExtra("data");

        EditText et_sh_name = findViewById(R.id.et_sh_name);
        et_sh_name.setText(data.getLinkPerson());
        EditText et_phone = findViewById(R.id.et_phone);
        et_phone.setText(data.getLinkPhone());
        EditText et_xh_address = findViewById(R.id.et_xh_address);
        et_xh_address.setText(data.getDetailAddress());
        TextView tv_xz_dz = findViewById(R.id.tv_xz_dz);
        tv_xz_dz.setOnClickListener(this);
        Switch sw_mr_address = findViewById(R.id.sw_mr_address);
        sw_mr_address.setOnClickListener(this);
        Button btn_sanchu_dz = findViewById(R.id.btn_sanchu_dz);
        btn_sanchu_dz.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_xz_dz:
                //弹出 三级联动 地址
                break;
            case R.id.sw_mr_address:
                // 开关
                break;
            case R.id.btn_sanchu_dz:
                // 删除地址
                break;
        }
    }
}
