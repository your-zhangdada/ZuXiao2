package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyordFragmentPagerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.MyFragment_order;

import java.util.ArrayList;
import java.util.List;

//我的订单主页
public class MyorderActivity extends BaseActivity {
    private List<String> mList = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    private TabLayout my_tab_order;
    private ViewPager my_pager_order;

    @Override
    protected void initTitle() {
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_myorder;
    }
                //TODO
    @Override
    protected void initView() {
        my_tab_order = findViewById(R.id.my_tab_order);
        my_pager_order = findViewById(R.id.my_pager_order);
        my_tab_order.setupWithViewPager(my_pager_order);
        //全部订单Fragment
        mList.add("全部");
        mList.add("待付款");
        mList.add("待发货");
        mList.add("待收货");
        mList.add("售后退款");
        for (int i = 0; i < mList.size(); i++) {
            MyFragment_order myFragment_order = new MyFragment_order();
            mFragment.add(myFragment_order);
        }
        MyordFragmentPagerAdapter myordFragmentPagerAdapter = new MyordFragmentPagerAdapter(getSupportFragmentManager(), mFragment, mList);
        my_pager_order.setAdapter(myordFragmentPagerAdapter);

    }

    @Override
    protected void initData() {

    }

}
