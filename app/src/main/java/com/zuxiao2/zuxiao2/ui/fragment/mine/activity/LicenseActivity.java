package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 *   TODO 营业执照认证
 */
public class LicenseActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private TextView tv_delete_jpg_one,tv_delete_jpg_two;
    private ImageView im_zz_one,im_zz_two;
    private Button btn_zz_sc;
   @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_license;
    }

    @Override
    protected void initView() {
       // 点击 X  删除照片
        tv_delete_jpg_one = findViewById(R.id.tv_delete_jpg_one);
        tv_delete_jpg_two = findViewById(R.id.tv_delete_jpg_two);
        tv_delete_jpg_one.setOnClickListener(this);
        tv_delete_jpg_two.setOnClickListener(this);
        // 营业执照  与 扫描件
        im_zz_one = findViewById(R.id.im_zz_one);
        im_zz_two = findViewById(R.id.im_zz_two);
        im_zz_one.setOnClickListener(this);
        im_zz_two.setOnClickListener(this);
        //立即上传
        btn_zz_sc = findViewById(R.id.btn_zz_sc);
        btn_zz_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_delete_jpg_one:// 点击 X  删除照片
                break;
            case R.id.tv_delete_jpg_two:// 点击 X  删除照片
                break;
            case R.id.im_zz_one:// 营业执照  与 扫描件
                break;
            case R.id.im_zz_two:// 营业执照  与 扫描件
                break;
            case R.id.btn_zz_sc:  //立即上传
                getLicensePost();
                break;
        }
    }

    private void getLicensePost() {
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",3+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",10+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("businessLicense",url);//营业执照

        presenter.getLicenseApply(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
       // TODO 营业执照 返回数据
        Toast.makeText(this, applyBean.toString(), Toast.LENGTH_SHORT).show();
    }
}
