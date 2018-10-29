package com.zuxiao2.zuxiao2.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CommodityBean;

public class Activity_AddDZ extends BaseActivity implements View.OnClickListener {
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_equipment_return;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        CommodityBean.DataBean databena = (CommodityBean.DataBean) intent.getSerializableExtra("databena");
        Button btn_zf = findViewById(R.id.btn_zf);
        btn_zf.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zf:

                break;
        }
    }
}
