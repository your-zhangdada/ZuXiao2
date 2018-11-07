package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyordFragmentPagerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.EquipMentFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  TODO 我的设备
 */
public class EquipmentActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout im_finsch;
    private TabLayout my_rquip_tab;
    private ViewPager my_rquip_viewpaoger;
    private List<String> mList = Arrays.asList("租赁中","到期提醒","待归还","已完成");
    private List<Integer> mTitlePosition = Arrays.asList( 0, 1, 2, 3);
    private List<Fragment> mFragment = new ArrayList<>();
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_equipment;
    }

    @Override
    protected void initView() {
        im_finsch = findViewById(R.id.im_finsch);
        im_finsch.setOnClickListener(this);
        my_rquip_tab = findViewById(R.id.my_rquip_tab);
        my_rquip_viewpaoger = findViewById(R.id.my_rquip_viewpaoger);
        my_rquip_tab.setupWithViewPager(my_rquip_viewpaoger);

    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitlePosition.size(); i++) {
            EquipMentFragment equipMentFragment = new EquipMentFragment();
            mFragment.add(equipMentFragment);
            Bundle bundle = new Bundle();
            bundle.putInt("Tabid",mTitlePosition.get(i));
            equipMentFragment.setArguments(bundle);
        }
        MyordFragmentPagerAdapter myordFragmentPagerAdapter = new MyordFragmentPagerAdapter(getSupportFragmentManager(),mFragment,mList);
        my_rquip_viewpaoger.setAdapter(myordFragmentPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
