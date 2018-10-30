package com.zuxiao2.zuxiao2.ui.fragment.mine.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyordFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragment;
    List<String> mList;
    public MyordFragmentPagerAdapter(FragmentManager fm, List<Fragment> mFragment, List<String> mList) {
        super(fm);
        this.mFragment = mFragment;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
