package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.CompanyActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.EducationActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SBKActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SengfenActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.ZhiCanActivity;

/**     个人认证
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment implements View.OnClickListener {
 private ImageView im_sfz,im_sbk,im_zc,im_zm,im_xl,im_gs;
 private TextView tv_sfz,tv_sfz_rz,tv_sbk_rz,tv_sbk,tv_zc,tv_zc_rz,tv_zm,tv_zm_rz,tv_xl,tv_xl_rz,tv_gs,tv_gs_rz;
    @Override
    protected int getCreateView() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initView(View view) {
        // 身份证认证
        im_sfz = view.findViewById(R.id.im_sfz);
        tv_sfz = view.findViewById(R.id.tv_sfz);
        tv_sfz_rz = view.findViewById(R.id.tv_sfz_rz);
        tv_sfz_rz.setOnClickListener(this);
        //社保卡
        im_sbk = view.findViewById(R.id.im_sbk);
        tv_sbk = view.findViewById(R.id.tv_sbk);
        tv_sbk_rz = view.findViewById(R.id.tv_sbk_rz);
        tv_sbk_rz.setOnClickListener(this);
        //固定资产
        im_zc = view.findViewById(R.id.im_zc);
        tv_zc = view.findViewById(R.id.tv_zc);
        tv_zc_rz = view.findViewById(R.id.tv_zc_rz);
        tv_zc_rz.setOnClickListener(this);
        //芝麻信用
        im_zm = view.findViewById(R.id.im_zm);
        tv_zm = view.findViewById(R.id.tv_zm);
        tv_zm_rz = view.findViewById(R.id.tv_zm_rz);
        tv_zm_rz.setOnClickListener(this);
        //学历认证
        im_xl = view.findViewById(R.id.im_xl);
        tv_xl = view.findViewById(R.id.tv_xl);
        tv_xl_rz = view.findViewById(R.id.tv_xl_rz);
        tv_xl_rz.setOnClickListener(this);
       //公司信息认证
        im_gs = view.findViewById(R.id.im_gs);
        tv_gs = view.findViewById(R.id.tv_gs);
        tv_gs_rz = view.findViewById(R.id.tv_gs_rz);
        tv_gs_rz.setOnClickListener(this);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_sfz_rz:// 身份证认证
                startActivity(new Intent(getContext(),SengfenActivity.class));
                break;
            case R.id.tv_sbk_rz:  //社保卡
                startActivity(new Intent(getContext(),SBKActivity.class));
                break;
            case R.id.tv_zc_rz:  //固定资产
                startActivity(new Intent(getContext(),ZhiCanActivity.class));
                break;
            case R.id.tv_zm_rz:  //芝麻信用
                break;
            case R.id.tv_xl_rz: //学历认证
                startActivity(new Intent(getContext(),EducationActivity.class));
                break;
            case R.id.tv_gs_rz: //公司信息认证
                startActivity(new Intent(getContext(),CompanyActivity.class));
                break;
        }
    }
}
