package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class Merchantentry extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextView tv_xieyi, im_addres;
    private EditText tv_company_name, tv_staff_Number, tv_shibie_Number, tv_management, tv_name, tv_id_number, ed_name, ed_name_phone, ed_xx_adds;
    private ImageView im_shengfenzhengoen, im_shengfenzhengtwo, im_addphotooen, im_addphototwo, im_yingyezao1, im_yingyezao2, im_yingyezao3;
    private Button btn_sc;
    private CheckBox chechbox_xuanzhe;
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
        //  联系人
        ed_name = findViewById(R.id.ed_name);
        //联系电话
        ed_name_phone = findViewById(R.id.ed_name_phone);
        //选着地址
        im_addres = findViewById(R.id.im_addres);
        im_addres.setOnClickListener(this);
        //详细地址
        ed_xx_adds = findViewById(R.id.ed_xx_adds);
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
        //选择框
        chechbox_xuanzhe = findViewById(R.id.chechbox_xuanzhe);
        chechbox_xuanzhe.setOnCheckedChangeListener(this);
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
        switch (v.getId()){
            case R.id.im_addres://选着地址
                break;
                 case R.id.im_shengfenzhengoen://正面省份证照 拍照
            break;
             case R.id.im_shengfenzhengtwo:// 反面省份证照 拍照
            break;
             case R.id.im_addphotooen: //上传手持省份证 拍照
            break;
             case R.id.im_yingyezao3://上传营业执照  相册和拍照
            break;
            case R.id.tv_xieyi: //查看协议
            break;
             case R.id.btn_sc: //上传
            break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 选着框 点击事件
    }
}
