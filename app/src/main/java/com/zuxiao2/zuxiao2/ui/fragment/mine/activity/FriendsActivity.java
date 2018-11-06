package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * TODO 邀请好友
 */
public class FriendsActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout im_back;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_friends;
    }

    @Override
    protected void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
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
        }
    }
}
