package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * 设置页面
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_out_login;
    private RelativeLayout rv_about_us, rv_message;
    private TextView tv_about_us, tv_message;
    private ImageView im_about_us, im_message;
    private RelativeLayout rv_clean_up_caching;
    private RelativeLayout rv_check_version;

    @Override
    protected void initTitle() {
        //设置标题
        TextView tille = (TextView) findViewById(R.id.title);
        tille.setText(R.string.setting);

        //设置背景
        RelativeLayout rv_title = (RelativeLayout) findViewById(R.id.rv_title);

        //设置返回键
        ImageView im_back = (ImageView) findViewById(R.id.im_back);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    protected void initView() {
        //新消息提醒
        rv_message = findViewById(R.id.rv_message);
        tv_message = findViewById(R.id.tv_message);
        im_message = findViewById(R.id.im_message);
        rv_message.setOnClickListener(this);
        // 清楚缓存
        rv_clean_up_caching = findViewById(R.id.rv_clean_up_caching);
        rv_clean_up_caching.setOnClickListener(this);
        //检测更新
        rv_check_version = findViewById(R.id.rv_check_version);
        rv_check_version.setOnClickListener(this);
        //关于我们
        rv_about_us = findViewById(R.id.rv_about_us);
        tv_about_us = findViewById(R.id.tv_about_us);
        im_about_us = findViewById(R.id.im_about_us);
        rv_about_us.setOnClickListener(this);
        //退出登录
        bt_out_login = findViewById(R.id.bt_out_login);
        bt_out_login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //新消息提醒
            case R.id.rv_message:
                Intent intent = new Intent(this,MeassgeSettingActivity.class);
                startActivity(intent);
                break;
            // 清楚缓存
            case R.id.rv_clean_up_caching:
                break;
            //检测更新
            case R.id.rv_check_version:
                //关于我们
                break;
            case R.id.rv_about_us:
                //退出登录
                break;
            case R.id.bt_out_login:
                break;

        }
    }
}
