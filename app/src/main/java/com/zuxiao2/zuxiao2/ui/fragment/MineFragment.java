package com.zuxiao2.zuxiao2.ui.fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.login.LoginActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.MyorderActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SettingActivity;

/** 我的页面
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    TextView user_name;
    private ImageView im_order,im_equipment,im_re,im_setting;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        im_setting = view.findViewById(R.id.im_setting);
        im_setting.setOnClickListener(this);
        //点击登录
        user_name = view.findViewById(R.id.user_name);
        user_name.setOnClickListener(this);
        //我的订单
        im_order = view.findViewById(R.id.im_order);
        im_order.setOnClickListener(this);
        //我的设备
        im_equipment = view.findViewById(R.id.im_equipment);
        im_equipment.setOnClickListener(this);
        //我的钱包
        im_re = view.findViewById(R.id.im_re);
        im_re.setOnClickListener(this);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_setting:
                Intent setting = new Intent(getContext(), SettingActivity.class);
                startActivity(setting);
                break;
            case R.id.user_name:
                Intent login = new Intent(getContext(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.im_order:
                //我的订单  先判断是否登录  登录以后才可以点击  否者跳转到登录页面
                Intent Order = new Intent(getContext(),MyorderActivity.class);
                startActivity(Order);
                break;
            case R.id.im_equipment:
                //我的设备
               // Intent equipment = new Intent(getContext(), );
              //  startActivity(equipment);
                break;
            case R.id.im_re:
                //我的钱包
//                Intent wallet = new Intent(getContext(), );
//                startActivity(wallet);
                break;
        }
    }
}
