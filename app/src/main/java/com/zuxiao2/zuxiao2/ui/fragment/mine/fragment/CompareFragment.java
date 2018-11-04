package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.ApplyListBean;
import com.zuxiao2.zuxiao2.contract.ApplyListContract;
import com.zuxiao2.zuxiao2.presenter.ApplyListPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.EnterpriseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.LicenseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SengfenActivity;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.HashMap;
import java.util.List;

/**         TODO 企业认证
 * A simple {@link Fragment} subclass.
 */
public class CompareFragment extends BaseFragment<ApplyListPresenter> implements ApplyListContract.View,View.OnClickListener {
    private ImageView im_fr_sfz,im_yy,im_qy;
    private TextView tv_fe_sfz,tv_fr_rz,tv_yy,tv_yy_rz,tv_qy,tv_qy_rz;
    private String name;
    private int status;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_compare;
    }

    @Override
    protected void initView(View view) {
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
    protected void initData(View view) {
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(getContext()));
        header.put("uuid",SpUtils.getUserId());
        presenter.getApplyList(header);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_fr_rz:     //法人省份证
                startActivity(new Intent(getContext(),SengfenActivity.class));
            break;
            case R.id.tv_yy_rz:    //营业执照
                startActivity(new Intent(getContext(),LicenseActivity.class));
                break;
            case R.id.tv_qy_rz:   //企业信息认证
                startActivity(new Intent(getContext(),EnterpriseActivity.class));
                break;
        }
    }

    @Override
    public void showApplyListBean(ApplyListBean applyListBean) {
        //0是申请中，1是审核通过，-1审核失败
        try{
            List<ApplyListBean.DataBean.AuthTypeLastBean> authTypeLast = applyListBean.getData().getAuthTypeLast();
            for (int i = 0; i < authTypeLast.size(); i++) {
                name = authTypeLast.get(i).getName();
                status = authTypeLast.get(i).getStatus();
            }
            if (name.equals("身份证认证")&& status == 0){
                tv_fr_rz.setText("审核中");
            }
            if (name.equals("身份证认证")&& status == 1){
                tv_fr_rz.setText("审核通过");
            }
            if (name.equals("身份证认证")&& status == -1){
                tv_fr_rz.setText("审核失败");
            }

            if (name.equals("营业执照认证")&& status == 0){
                tv_yy_rz.setText("审核中");
            }
            if (name.equals("营业执照认证")&& status == 1){
                tv_yy_rz.setText("审核通过");
            }
            if (name.equals("营业执照认证")&& status == -1){
                tv_yy_rz.setText("审核失败");
            }

            if (name.equals("企业信息认证")&& status == 0){
                tv_qy_rz.setText("审核中");
            }
            if (name.equals("企业信息认证")&& status == 1){
                tv_qy_rz.setText("审核通过");
            }
            if (name.equals("企业信息认证")&& status == -1){
                tv_qy_rz.setText("审核失败");
            }
        }catch (Exception e){
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(getContext()));
        header.put("uuid",SpUtils.getUserId());
        presenter.getApplyList(header);
    }
}
