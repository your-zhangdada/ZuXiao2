package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 社保卡认证
 */
public class SBKActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View, View.OnClickListener {

    private ImageView im_pz;
    private Button btn_tijiao;
    private EditText ed_sbk,ed_sfz,ed_sf_name;
    private String name,sfz,sbk;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sbk;
    }

    @Override
    protected void initView() {
        ed_sf_name = findViewById(R.id.ed_sf_name);//省份证姓名
        name = ed_sf_name.getText().toString();
        ed_sfz = findViewById(R.id.ed_sfz);// 省份证号
        sfz = ed_sfz.getText().toString();
        ed_sbk = findViewById(R.id.ed_sbk);//社保卡号
        sbk = ed_sbk.getText().toString();
        im_pz = findViewById(R.id.im_pz);//拍照
        im_pz.setOnClickListener(this);
        btn_tijiao = findViewById(R.id.btn_tijiao);// 提交
        btn_tijiao.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_pz: //拍照
                break;
            case R.id.btn_tijiao:// 提交
                initCardPost();
                break;
        }
    }

    private void initCardPost() { //社保卡
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",2+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",5+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("idCardName",name);//省份证名称
        map.put("idCardNum",sfz);//省份证号码
        map.put("socialSecurityNum",sbk);//社保卡
        map.put("socialSecurityPic",url);//社保卡照片
        presenter.getApplyCard(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {//社保卡返回数据
       // Toast.makeText(this, applyBean.toString(), Toast.LENGTH_SHORT).show();
    }
}
