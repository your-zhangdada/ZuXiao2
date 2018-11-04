package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.ApplyListBean;
import com.zuxiao2.zuxiao2.contract.ApplyListContract;
import com.zuxiao2.zuxiao2.presenter.ApplyListPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.OperateActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.SengfenActivity;
import com.zuxiao2.zuxiao2.ui.fragment.mine.activity.StudentActivity;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.HashMap;
import java.util.List;
//学生认证
/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends BaseFragment<ApplyListPresenter> implements ApplyListContract.View,View.OnClickListener {

    private Button bt_to_st_id,bt_to_st,bt_to_yuny,bt_to_zhima;
    private int status;
    private String name;

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
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(getContext()));
        header.put("uuid",SpUtils.getUserId());
        presenter.getApplyList(header);
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
                startActivity(new Intent(getContext(),OperateActivity.class));
                break;
            case R.id.bt_to_zhima://芝麻信用
           // startActivity(new Intent(getContext(),));//暂时没有
                break;
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

    @Override
    public void showApplyListBean(ApplyListBean applyListBean) {
        //0是申请中，1是审核通过，-1审核失败
        try {
            List<ApplyListBean.DataBean.AuthTypeLastBean> authTypeLast = applyListBean.getData().getAuthTypeLast();
            for (int i = 0; i < authTypeLast.size(); i++) {
                name = authTypeLast.get(i).getName();
                status = authTypeLast.get(i).getStatus();
            }
            if (name.equals("身份证认证")&&status==0){
                bt_to_st_id.setText("审核中");
            }
            if (name.equals("身份证认证")&&status==1){
                bt_to_st_id.setText("审核通过");
            }
            if (name.equals("身份证认证")&&status == -1){
                bt_to_st_id.setText("审核失败");
            }

            if (name.equals("学生认证")&&status==0){
                bt_to_st.setText("审核中");
            }
            if (name.equals("学生认证")&&status==1){
                bt_to_st.setText("审核通过");
            }
            if (name.equals("学生认证")&&status == -1){
                bt_to_st.setText("审核失败");
            }

            if (name.equals("运营商认证")&&status==0){
                bt_to_yuny.setText("审核中");
            }
            if (name.equals("运营商认证")&&status==1){
                bt_to_yuny.setText("审核通过");
            }
            if (name.equals("运营商认证")&&status == -1){
                bt_to_yuny.setText("审核失败");
            }

            if (name.equals("芝麻信用")&&status==0){
                bt_to_zhima.setText("审核中");
            }
            if (name.equals("芝麻信用")&&status==1){
                bt_to_zhima.setText("审核通过");
            }
            if (name.equals("芝麻信用")&&status == -1){
                bt_to_zhima.setText("审核失败");
            }
        }catch (Exception e){
            Toast.makeText(getContext(), "网络异常", Toast.LENGTH_SHORT).show();
        }
        }
}
