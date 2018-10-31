package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**2018年10月31日15:51:22 创建
 * 运营商认证
 */
public class OperateActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private EditText tv_phonenub,ed_operate;
    private Button btn_tijiao_rz;
    private String phonenub;
    private String operate;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_operate;
    }

    @Override
    protected void initView() {
        tv_phonenub = findViewById(R.id.tv_phonenub);//手机号
        phonenub = tv_phonenub.getText().toString();
        ed_operate = findViewById(R.id.ed_operate);// 运营商
        operate = ed_operate.getText().toString();
        btn_tijiao_rz = findViewById(R.id.btn_tijiao_rz);// 提交认证
        btn_tijiao_rz.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tijiao_rz:
                getOperate();
                break;
        }
    }

    private void getOperate() {
        //提交认证请求
        Map<String,String> map = new HashMap<>();
        map.put("phone",phonenub);
        map.put("operator",operate);
       presenter.getApplyOperate(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
        //返回参数
        Log.e("运营商认证",applyBean.toString());
    }
}
