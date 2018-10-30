package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.ProvinPagerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.CompareFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.PersonFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.StudentFragment;

import java.util.ArrayList;
import java.util.List;

public class ProvinceActivity extends BaseActivity {
    private TabLayout provin_tab;
    private ViewPager provin_viewpager;
    private List<String> mList = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    // 省份认证

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_province;
    }

    @Override
    protected void initView() {
        mList.add("学生认证");
        mList.add("个人认证");
        mList.add("企业认证");
        mFragment.add(new StudentFragment());//学生认证
        mFragment.add(new PersonFragment()); //个人认证
        mFragment.add(new CompareFragment()); //企业认证
        provin_tab = findViewById(R.id.provin_tab);
        provin_viewpager = findViewById(R.id.provin_viewpager);
        provin_tab.setupWithViewPager(provin_viewpager);
        ProvinPagerAdapter adapter = new ProvinPagerAdapter(getSupportFragmentManager(), mFragment, mList);
        provin_viewpager.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }
}
