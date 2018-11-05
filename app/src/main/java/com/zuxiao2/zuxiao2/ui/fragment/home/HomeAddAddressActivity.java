package com.zuxiao2.zuxiao2.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

//添加收货地址
public class HomeAddAddressActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout im_boack;
    private TextView title_right;
    private RecyclerView my_address_recycler;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_home_add_address;
    }

    @Override
    protected void initView() {
        im_boack = findViewById(R.id.im_boack);
        im_boack.setOnClickListener(this);
        title_right = findViewById(R.id.title_right);
        title_right.setOnClickListener(this);
        my_address_recycler = findViewById(R.id.my_address_recycler);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.im_boack:
                    finish();
                    break;
                case R.id.title_right:
                    break;
            }
    }
}
