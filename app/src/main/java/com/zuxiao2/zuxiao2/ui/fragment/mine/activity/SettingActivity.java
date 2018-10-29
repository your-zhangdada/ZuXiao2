package com.zuxiao2.zuxiao2.activitys.user.set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.utils.SharePreferenceUtil;
import com.zuxiao2.zuxiao2.utils.ToastUtil;
import com.zuxiao2.zuxiao2.utils.UIHelper;

/**
 * 设置页面
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_out_login;
    SharePreferenceUtil sharePreferenceUtil;
    private RelativeLayout rv_about_us, rv_message;
    private TextView tv_about_us, tv_message;
    private ImageView im_about_us, im_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
        initToolbar();
        initView();

    }


    private void init() {
    }

    private void initView() {
        //退出登录
        bt_out_login = findViewById(R.id.bt_out_login);
        bt_out_login.setOnClickListener(this);
        sharePreferenceUtil = new SharePreferenceUtil(this, "user_info");
       /* if (sharePreferenceUtil.getId().isEmpty()) {
            bt_out_login.setText(R.string.app_login);
        } else {
            bt_out_login.setText(R.string.out_login);
        }
*/
        //关于我们
        rv_about_us = findViewById(R.id.rv_about_us);
        tv_about_us = findViewById(R.id.tv_about_us);
        im_about_us = findViewById(R.id.im_about_us);

        rv_about_us.setOnClickListener(this);
        tv_about_us.setOnClickListener(this);
        im_about_us.setOnClickListener(this);

        //新消息提醒
        rv_message = findViewById(R.id.rv_message);
        tv_message = findViewById(R.id.tv_message);
        im_message = findViewById(R.id.im_message);

        rv_message.setOnClickListener(this);
        tv_message.setOnClickListener(this);
        im_message.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            //退出登录
            case R.id.bt_out_login:
               /* if (bt_out_login.getText().equals(R.string.out_login)) {*/
                    sharePreferenceUtil.clear();
                    ToastUtil.showLong(this, R.string.out_login_success);
               /* } else {

                    UIHelper.showLoginActivity(this, null);
                }*/
                break;
            //关于我们
            case R.id.rv_about_us:
                UIHelper.showAboutUsActivity(this, null);
                break;
            case R.id.tv_about_us:
                UIHelper.showAboutUsActivity(this, null);
                break;
            case R.id.im_about_us:
                UIHelper.showAboutUsActivity(this, null);
                break;
            //新消息提醒
            case R.id.rv_message:
                UIHelper.showMeassgeSettingActivity(this, null);
                break;
            case R.id.tv_message:
                UIHelper.showMeassgeSettingActivity(this, null);
                break;
            case R.id.im_message:
                UIHelper.showMeassgeSettingActivity(this, null);
                break;

        }
    }


    private void initToolbar() {
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

    /*@Override
    public void onResume() {
        super.onResume();
        if (sharePreferenceUtil.getId().isEmpty()) {
            bt_out_login.setText(R.string.app_login);
        } else {
            bt_out_login.setText(R.string.out_login);
        }

    }*/
}
