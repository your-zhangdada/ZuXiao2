package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SengfenActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.StudentActivity;
//学生认证
/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends BaseFragment implements View.OnClickListener {

    private Button bt_to_st_id,bt_to_st,bt_to_yuny,bt_to_zhima;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_provin;
    }

    @Override
    protected void initView(View view) {
        bt_to_st_id = view.findViewById(R.id.bt_to_st_id);//省份证认证
        bt_to_st_id.setOnClickListener(this);
        bt_to_st = view.findViewById(R.id.bt_to_st); //学生认证
        bt_to_st.setOnClickListener(this);
        bt_to_yuny = view.findViewById(R.id.bt_to_yuny);//运营商认证
        bt_to_yuny.setOnClickListener(this);
        bt_to_zhima = view.findViewById(R.id.bt_to_zhima);//芝麻信用
        bt_to_zhima.setOnClickListener(this);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_to_st_id://省份证认证
                 startActivity(new Intent(getContext(),SengfenActivity.class));
                break;
            case R.id.bt_to_st://学生认证
                startActivity(new Intent(getContext(),StudentActivity.class));
                break;
            case R.id.bt_to_yuny://运营商认证
                break;
            case R.id.bt_to_zhima://芝麻信用
                break;
        }
    }
}
