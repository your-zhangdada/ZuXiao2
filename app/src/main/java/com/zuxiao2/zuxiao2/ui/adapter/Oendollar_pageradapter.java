package com.zuxiao2.zuxiao2.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zuxiao2.zuxiao2.ui.hometabftagment.Onedo_Fragment;

import java.util.List;

/**
 * 作者：wanglong on 18/10/18.
 * 邮箱：wanglong128@aliyun.com
 * 版本：v1.0
 */
public class Oendollar_pageradapter  extends FragmentPagerAdapter {
    List<Onedo_Fragment> mFragment;
    List<String> data;
    Context context;

    public Oendollar_pageradapter(FragmentManager fragmentManager, List<Onedo_Fragment> mFragment, List<String> data) {
        super(fragmentManager);
        this.mFragment = mFragment;
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position);

    }
}
