package com.zuxiao2.zuxiao2.ui.activity;

import android.support.v4.view.ViewPager;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    private ViewPager viewPager;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    protected void initData() {

    }
}
