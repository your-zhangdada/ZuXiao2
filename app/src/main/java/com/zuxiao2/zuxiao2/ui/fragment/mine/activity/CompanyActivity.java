package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 *  TODO  公司信息认证
 */
public class CompanyActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    /**
     * 正则表达式:验证邮箱
     */ public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
    private ImageView im_com_person;
    private EditText tv_com_name,tv_post,tv_emile;
    private Button tv_huitui,bt_com_rz;
    private String com_name;
    private String post;
    private String emile;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView()
    {
        return R.layout.activity_company;
    }

    @Override
    protected void initView() {
        tv_com_name = findViewById(R.id.tv_com_name);//公司名称
        com_name = tv_com_name.getText().toString();
        tv_post = findViewById(R.id.tv_post);// 所处岗位
        post = tv_post.getText().toString();
        tv_emile = findViewById(R.id.tv_emile);//企业邮箱
        emile = tv_emile.getText().toString();
        im_com_person = findViewById(R.id.im_com_person);//拍照 工牌人像照
        im_com_person.setOnClickListener(this);
        tv_huitui = findViewById(R.id.tv_huitui); // 返回键
        tv_huitui.setOnClickListener(this);
        bt_com_rz = findViewById(R.id.bt_com_rz);//立即上传
        bt_com_rz.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_huitui://返回键
                finish();
                break;
            case R.id.im_com_person://拍照 工牌人像照
                break;
            case R.id.bt_com_rz://立即上传
                if (emile==regex){
                    getComPost();
                }else {
                    Toast.makeText(this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void getComPost() {
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",2+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",7+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("companyName",com_name);//公司名称
        map.put("companyRole",post);//所处岗位
        map.put("companyEmail",emile);//企业邮箱
        map.put("companyCardPic",url);// 工牌照片
        presenter.getComApply(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
        // 公司信息返回数据
        Toast.makeText(this, applyBean.toString(), Toast.LENGTH_SHORT).show();
    }
}
