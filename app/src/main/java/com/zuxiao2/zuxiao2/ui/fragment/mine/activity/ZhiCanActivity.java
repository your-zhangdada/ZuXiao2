package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 *      TODO  固定资产
 */
public class ZhiCanActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private Button btn_zc_sc;
    private ImageView  im_zctu_one,im_zctu_two,im_zctu_three;
    @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_zhi_can;
    }

    @Override
    protected void initView() {
        im_zctu_one = findViewById(R.id.im_zctu_one);//资产 图 1  ID
        im_zctu_one.setOnClickListener(this);
        im_zctu_two = findViewById(R.id.im_zctu_two);//资产 图 2  ID
        im_zctu_two.setOnClickListener(this);
        im_zctu_three = findViewById(R.id.im_zctu_three);//资产 图 3  ID
        im_zctu_three.setOnClickListener(this);
        btn_zc_sc = findViewById(R.id.btn_zc_sc); //立即上传
        btn_zc_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_zctu_one://资产 图 1  ID
                break;
            case R.id.im_zctu_two://资产 图 2  ID
                break;
            case R.id.im_zctu_three://资产 图 3  ID
                break;
            case R.id.btn_zc_sc://立即上传
                getZiChanPost();
                break;
        }
    }

    private void getZiChanPost() {//固定资产
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",2+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("fixedMoney",8+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("fixedMoney",url);// 固定资产图片证明，多张图逗号分割
        presenter.getApplyAssets(map);
    }


    @Override
    public void showApplyBean(ApplyBean applyBean) {
        // TODO 报 100   未知错误
      //  Toast.makeText(this, applyBean.toString(), Toast.LENGTH_SHORT).show();
    }
}
