package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.MyFragment_order;

//我的订单主页
public class MyorderActivity extends BaseActivity {

    private TabLayout my_tab_order;
    private ViewPager my_pager_order;

    @Override
    protected void initTitle() {
        //顶部标题
       ImageView im_back =  findViewById(R.id.im_back);
       TextView  register_title =findViewById(R.id.register_title);
        register_title.setText("我的订单");
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_myorder;
    }

    @Override
    protected void initView() {
        //全部订单Fragment
        MyFragment_order myFragment_order = new MyFragment_order();

        my_tab_order = findViewById(R.id.my_tab_order);
        my_pager_order = findViewById(R.id.my_pager_order);
        my_tab_order.setupWithViewPager(my_pager_order);


    }

    @Override
    protected void initData() {

    }
}
