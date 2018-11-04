package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.ProvinPagerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.CompareFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.PersonFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.fragment.StudentFragment;

import java.util.ArrayList;
import java.util.List;
// TODO 省份认证
public class ProvinceActivity extends BaseActivity implements View.OnClickListener {
    private TabLayout provin_tab;
    private ViewPager provin_viewpager;
    private List<String> mList = new ArrayList<>();
    private List<Fragment> mFragment = new ArrayList<>();
    private ImageView im_back;
    private TextView title_right;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_province;
    }

    @Override
    protected void initView() {
        mList.add("学生认证");  // 已完成
        mList.add("个人认证"); // 已完成
        mList.add("企业认证");
        mFragment.add(new StudentFragment());//学生认证
        mFragment.add(new PersonFragment()); //个人认证
        mFragment.add(new CompareFragment()); //企业认证
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
        title_right = findViewById(R.id.title_right);
        title_right.setOnClickListener(this);
        provin_tab = findViewById(R.id.provin_tab);
        provin_viewpager = findViewById(R.id.provin_viewpager);
        provin_tab.setupWithViewPager(provin_viewpager);
        ProvinPagerAdapter adapter = new ProvinPagerAdapter(getSupportFragmentManager(), mFragment, mList);
        provin_viewpager.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_back:
                finish();
                break;
            case R.id.title_right:
                Toast.makeText(this, "暂未开放", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
