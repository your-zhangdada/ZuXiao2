package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class Merchantentry extends BaseActivity implements View.OnClickListener {

    private TextView tv_xieyi;
    private EditText tv_company_name, tv_staff_Number, tv_shibie_Number, tv_management, tv_name, tv_id_number;
    private ImageView im_shengfenzhengoen, im_shengfenzhengtwo, im_addphotooen, im_addphototwo, im_yingyezao1, im_yingyezao2, im_yingyezao3;
    Button btn_sc;

    private Bitmap bitmap;
    private String bitmaoStr;
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_merchantentry;
    }

    @Override
    protected void initView() {
//公司名称
        tv_company_name = findViewById(R.id.tv_company_name);
//员工人数
        tv_staff_Number = findViewById(R.id.tv_staff_Number);
//纳税人识别码
        tv_shibie_Number = findViewById(R.id.tv_shibie_Number);
//经营范围
        tv_management = findViewById(R.id.tv_management);
//法人姓名
        tv_name = findViewById(R.id.tv_name);
//省份证号
        tv_id_number = findViewById(R.id.tv_id_number);

//正面省份证照片 拍照
        im_shengfenzhengoen = findViewById(R.id.im_shengfenzhengoen);
        im_shengfenzhengoen.setOnClickListener(this);
//反面省份证照片 拍照
        im_shengfenzhengtwo = findViewById(R.id.im_shengfenzhengtwo);
        im_shengfenzhengtwo.setOnClickListener(this);
//上传手持省份证 拍照
        im_addphotooen = findViewById(R.id.im_addphotooen);
        im_addphotooen.setOnClickListener(this);
        im_addphototwo = findViewById(R.id.im_addphototwo);
//上传营业执照  相册与拍照
        im_yingyezao1 = findViewById(R.id.im_yingyezao1);
        im_yingyezao2 = findViewById(R.id.im_yingyezao2);
        im_yingyezao3 = findViewById(R.id.im_yingyezao3);
        im_yingyezao3.setOnClickListener(this);
//查看协议
        tv_xieyi = findViewById(R.id.tv_xieyi);
        tv_xieyi.setOnClickListener(this);
//上传
        btn_sc = findViewById(R.id.btn_sc);
        btn_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
