package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.HashMap;
import java.util.Map;

//省份证认证
public class SengfenActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View, View.OnClickListener {

    private EditText tv_sfname,tv_sfz_hm,tv_sfz_dz;
    private ImageView im_shenfengoen,im_shenfengtwo,im_id,im_sc_zhenmian;
    private Button bt_id_au;
    private String sfname;
    private String sfz_hm;
    private String sfz_dz;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sengfen;
    }

    @Override
    protected void initView() {
        tv_sfname = findViewById(R.id.tv_sfname);//省份证姓名
        sfname = tv_sfname.getText().toString();
        tv_sfz_hm = findViewById(R.id.tv_sfz_hm); //省份证号
        sfz_hm = tv_sfz_hm.getText().toString();
        tv_sfz_dz = findViewById(R.id.tv_sfz_dz);//省份地址
        sfz_dz = tv_sfz_dz.getText().toString();
        im_shenfengoen = findViewById(R.id.im_shenfengoen);//身份证正面照
        im_shenfengoen.setOnClickListener(this);
        im_shenfengtwo = findViewById(R.id.im_shenfengtwo);//省份证 反面照
        im_shenfengtwo.setOnClickListener(this);
        im_id = findViewById(R.id.im_id);//点击拍照
        im_id.setOnClickListener(this);
        im_sc_zhenmian = findViewById(R.id.im_sc_zhenmian);//拍照完成的图片
        bt_id_au = findViewById(R.id.bt_id_au);//立即上传
        bt_id_au.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_shenfengoen://身份证正面照
                break;
            case R.id.im_shenfengtwo://省份证 反面照
                break;
            case R.id.im_id://点击拍照
                break;
            case R.id.bt_id_au://立即上传
                getApply();

                break;
        }
    }

    private void getApply() {

        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",1+""); //认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",1+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
//        map.put("schoolName","");
//        map.put("schoolRoll","");
//        map.put("major","");
//        map.put("schoolRollAddress","");
        map.put("stuCardFront",url);//证件正面-学生证或者身份证
        map.put("stuCardBehind",url);//证件反面
        map.put("idCardName",sfname);//身份证名称
        map.put("idCardNum",sfz_hm);//身份证号码
        map.put("idCardAddress",sfz_dz);//身份证地址
//        map.put("phone","");
//        map.put("operator","");
//        map.put("socialSecurityNum","");
//        map.put("socialSecurityPic","");
//        map.put("stuGraduatePic","");
//        map.put("companyName","");
//        map.put("companyRole","");
//        map.put("companyEmail","");
//        map.put("companyCardPic","");
//        map.put("employeeCount","");
//        map.put("fixedMoney","");
//        map.put("businessLicense","");
//        map.put("companyAddPact","");
//        map.put("companyFixedPact","");
//        map.put("companyPatent","");
//        map.put("companyAddress","");
//        map.put("entrustPic","");
        map.put("idCardHands",url);//手持身份证
        if (!SpUtils.getNikeName(this).isEmpty()){
            presenter.getApplyBean(map);
        }
    }
    @Override
    public void showApplyBean(ApplyBean applyBean) {
        Log.e("GET",applyBean.toString());
    }
}
