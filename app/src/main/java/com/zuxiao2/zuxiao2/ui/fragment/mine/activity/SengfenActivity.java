package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class SengfenActivity extends BaseActivity implements View.OnClickListener {

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
                break;
        }
    }
}
