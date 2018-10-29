package com.zuxiao2.zuxiao2.activitys.user.set;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * 消息提醒设置
 */
public class MeassgeSettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meassge_setting);
        init();
        initToolbar();
        initView();
    }

    private void initView() {


    }

    private void initToolbar() {
        //设置标题
        TextView tille = (TextView) findViewById(R.id.title);
        tille.setText(R.string.setting_title);

        //设置背景
        RelativeLayout rv_title = (RelativeLayout) findViewById(R.id.rv_title);

        //设置返回键
        ImageView im_back = (ImageView) findViewById(R.id.im_back);
        im_back.setImageResource(R.mipmap.back_black_left);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
    }
}
