package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;

/**         TODO 企业认证
 * A simple {@link Fragment} subclass.
 */
public class CompareFragment extends BaseFragment implements View.OnClickListener {
    private ImageView im_fr_sfz,im_yy,im_qy;
    private TextView tv_fe_sfz,tv_fr_rz,tv_yy,tv_yy_rz,tv_qy,tv_qy_rz;
    @Override
    protected int getCreateView() {
        return R.layout.fragment_compare;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(View view) {
        //法人省份证
        im_fr_sfz = view.findViewById(R.id.im_fr_sfz);
        tv_fe_sfz = view.findViewById(R.id.tv_fe_sfz);
        tv_fr_rz = view.findViewById(R.id.tv_fr_rz);
        tv_fr_rz.setOnClickListener(this);
        //营业执照
        im_yy = view.findViewById(R.id.im_yy);
        tv_yy = view.findViewById(R.id.tv_yy);
        tv_yy_rz = view.findViewById(R.id.tv_yy_rz);
        tv_yy_rz.setOnClickListener(this);
        //企业信息认证
        im_qy = view.findViewById(R.id.im_qy);
        tv_qy = view.findViewById(R.id.tv_qy);
        tv_qy_rz = view.findViewById(R.id.tv_qy_rz);
        tv_qy_rz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_fr_rz:     //法人省份证
            break;
            case R.id.tv_yy_rz:    //营业执照
                break;
            case R.id.tv_qy_rz:   //企业信息认证
                break;
        }
    }
}
