package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * 消息提醒设置
 */
public class MeassgeSettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch sb_receive_new_message;
    private Switch sb_voice;
    private Switch sb_new_message_hints;
    private Switch sb_shock;

    @Override
    protected void initTitle() {
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
    @Override
    protected int getContentView() {
        return R.layout.activity_meassge_setting;
    }

    @Override
    protected void initView() {

        // 接受新消息
        sb_receive_new_message = findViewById(R.id.sb_receive_new_message);
        sb_receive_new_message.setOnCheckedChangeListener(this);
        //声音
        sb_voice = findViewById(R.id.sb_voice);
        sb_voice.setOnCheckedChangeListener(this);
        // 新消息提示音
        sb_new_message_hints = findViewById(R.id.sb_new_message_hints);
        sb_new_message_hints.setOnCheckedChangeListener(this);
        // 震动
        sb_shock = findViewById(R.id.sb_shock);
        sb_shock.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
        }
    }
}
