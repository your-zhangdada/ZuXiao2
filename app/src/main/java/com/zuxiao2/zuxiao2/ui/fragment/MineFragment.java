package com.zuxiao2.zuxiao2.ui.fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.login.LoginActivity;
import com.zuxiao2.zuxiao2.ui.fragment.fication.activity.Merchantentry;
import com.zuxiao2.zuxiao2.ui.fragment.fication.activity.SettingActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.EquipmentActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.MyorderActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.ProvinceActivity;
import com.zuxiao2.zuxiao2.utils.SpUtils;

/**   TODO 我的页面
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    TextView user_name;
    private ImageView im_equipment,im_re,im_setting;
    private RelativeLayout rv_wall,rv_identity_text;
    private RelativeLayout myorder;

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

        //我的订单
        myorder = view.findViewById(R.id.myorder);
        myorder.setOnClickListener(this);
        //我的设备
        im_equipment = view.findViewById(R.id.im_equipment);
        im_equipment.setOnClickListener(this);
        //我的钱包
        im_re = view.findViewById(R.id.im_re);
        im_re.setOnClickListener(this);
        //省份认证
        rv_identity_text = view.findViewById(R.id.rv_identity_text);
        rv_identity_text.setOnClickListener(this);
        //商家入驻
        rv_wall = view.findViewById(R.id.rv_wall);
        rv_wall.setOnClickListener(this);

    }


    @Override
    protected void initData(View view) {
        if (!TextUtils.isEmpty(SpUtils.getNikeName(getContext()))){
            user_name.setText(SpUtils.getNikeName(getContext()));
        }else {
            user_name.setText("点击登录");
            user_name.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_name:
                Intent login = new Intent(getContext(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.rv_identity_text: //身份认证
                if (user_name.getText().toString().isEmpty()){
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }else {
                    startActivity(new Intent(getContext(),ProvinceActivity.class));
                }
                break;
            case R.id.myorder:
                //我的订单  先判断是否登录  登录以后才可以点击  否者跳转到登录页面
                Intent Order = new Intent(getContext(),MyorderActivity.class);
                startActivity(Order);
                break;
            case R.id.im_equipment:
                //我的设备
               Intent equipment = new Intent(getContext(),EquipmentActivity.class);
              startActivity(equipment);
                break;
            case R.id.im_re:
                //我的钱包
//                Intent wallet = new Intent(getContext(), );
//                startActivity(wallet);
                break;
            case R.id.rv_wall:
                //商家入住
                startActivity(new Intent(getContext(),Merchantentry.class));
                break;
            case R.id.im_setting:
                Intent setting = new Intent(getContext(), SettingActivity.class);
                startActivity(setting);
                break;
        }
    }
}
