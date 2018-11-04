package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.OrderTabBean;
import com.zuxiao2.zuxiao2.contract.IOrderContract;
import com.zuxiao2.zuxiao2.presenter.OrderTabPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyordFragmentPagerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.MyFragment_order;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//我的订单主页
public class MyorderActivity extends BaseActivity<OrderTabPresenter> implements IOrderContract.View, View.OnClickListener {
    private List<String> mList = Arrays.asList("全部","待付款","待发货","待收货","售后退款");
    private List<Integer> mTitlePosition = Arrays.asList(-1, 0, 1, 2, 3);
    private List<Fragment> mFragment = new ArrayList<>();
    private TabLayout my_tab_order;
    private ViewPager my_pager_order;
    private ImageView img_back;

    @Override
    protected void initTitle() {
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_myorder;
    }
    @Override
    protected void initView() {
        my_tab_order = findViewById(R.id.my_tab_order);
        my_pager_order = findViewById(R.id.my_pager_order);
        my_tab_order.setupWithViewPager(my_pager_order);
        img_back = findViewById(R.id.order_img);
        img_back.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        presenter.getOrderTabBean();
    }

    @Override
    public void showOrderTabBean(OrderTabBean orderTabBean) {
        for (int i = 0; i < mTitlePosition.size(); i++) {
            MyFragment_order myFragment_order = new MyFragment_order();
            mFragment.add(myFragment_order);
            Bundle bundle = new Bundle();
            bundle.putInt("tabid",mTitlePosition.get(i));
            myFragment_order.setArguments(bundle);
        }
        MyordFragmentPagerAdapter myordFragmentPagerAdapter = new MyordFragmentPagerAdapter(getSupportFragmentManager(), mFragment, mList);
        my_pager_order.setAdapter(myordFragmentPagerAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.order_img:
                this.finish();
                break;
        }

    }
}
